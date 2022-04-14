package com.example.kotlinStructure.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.kotlinStructure.R
import com.example.kotlinStructure.base.BaseFragment
import com.example.kotlinStructure.data.model.general.RequestHeader
import com.example.kotlinStructure.data.model.loadParameter.LoadParametersRequest
import com.example.kotlinStructure.data.model.token.TokenRequest
import com.example.kotlinStructure.data.model.token.TokenResponse
import com.example.kotlinStructure.enums.SharedPrefKeys
import com.example.kotlinStructure.util.Constants
import com.example.kotlinStructure.util.LocalStatus
import com.example.kotlinStructure.util.Resource
import com.example.kotlinStructure.util.SharedPrefHelper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.setting_fragment.*
import javax.inject.Inject

@AndroidEntryPoint
class SettingFragment : BaseFragment() {

    private val viewModel: SettingViewModel by viewModels()

    @Inject
    lateinit var preference: SharedPrefHelper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View =
        inflater.inflate(R.layout.setting_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        saveButton.setOnClickListener {
            setTokenRequest()
        }
    }

    private fun initObservers() {
        subscribeTokenObserver()
        subscribeLoadParameterObserver()
        subscribeInsertUserObserver()
        subscribeInsertTerminalSettingObserver()
        subscribeInsertServiceProviderObserver()
        subscribeInsertServicesObserver()
    }

    private fun setTokenRequest() {
        viewModel.setTokenRequest(
            TokenRequest(
                RequestHeader(terminalIdTextInputLayout.editText!!.text.toString()),
                terminalIdTextInputLayout.editText!!.text.toString(),
                passwordTextInputLayout.editText!!.text.toString()
            )
        )
    }

    private fun subscribeTokenObserver() {
        viewModel.tokenLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    showLoader()
                }
                is Resource.Success -> {
                    setDataToSharedPref(it.data)
                    setLoadParameterRequest()
                }
                is Resource.Error -> {
                    dismissLoader()
                    Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun setDataToSharedPref(response: TokenResponse?) {
        Constants.applicationToken = response?.token.toString()
        preference.setStringToShared(SharedPrefKeys.token.name, response?.token.toString())
        preference.setStringToShared(SharedPrefKeys.tokenExpireDate.name, response?.expireDate!!)
        preference.setStringToShared(SharedPrefKeys.terminalId.name,
            terminalIdTextInputLayout.editText!!.text.toString().trim { it <= ' ' })
        preference.setStringToShared(SharedPrefKeys.password.name,
            passwordTextInputLayout.editText!!.text.toString().trim { it <= ' ' })
    }

    private fun setLoadParameterRequest() {
        viewModel.setLoadParametersRequest(
            LoadParametersRequest(
                RequestHeader(
                    preference.getStringFromShared(SharedPrefKeys.terminalId.name),
                    preference.getStringFromShared(SharedPrefKeys.password.name)
                ), null, preference.getStringFromShared(SharedPrefKeys.password.name)
            )
        )
    }

    private fun subscribeLoadParameterObserver() {
        viewModel.loadParametersLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                    viewModel.setLoadParametersData(it.data)
                    viewModel.insertUser()
                }
                is Resource.Error -> {
                    dismissLoader()
                    Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun subscribeInsertUserObserver() {
        viewModel.insertUserLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is LocalStatus.Success -> {
                    viewModel.insertTerminalSetting()
                }
                is LocalStatus.Error -> {
                    dismissLoader()
                    Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun subscribeInsertTerminalSettingObserver() {
        viewModel.insertTerminalSettingLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is LocalStatus.Success -> {
                    viewModel.insertServiceProvider()
                }
                is LocalStatus.Error -> {
                    dismissLoader()
                    Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun subscribeInsertServiceProviderObserver() {
        viewModel.insertServiceProviderLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is LocalStatus.Success -> {
                    viewModel.insertServices()
                }
                is LocalStatus.Error -> {
                    dismissLoader()
                    Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun subscribeInsertServicesObserver() {
        viewModel.insertServicesLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is LocalStatus.Success -> {
                    dismissLoader()
                    checkWhichToNavigateTo()
                }
                is LocalStatus.Error -> {
                    dismissLoader()
                    Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun checkWhichToNavigateTo() {
//        if (viewModel.getLoadParametersData()!!.terminalSetting.isPasswordChanged) {
        navigateTo(R.id.action_settingFragment_to_loginFragment)
//        }
//        else navigateToChangePassword()
    }
}