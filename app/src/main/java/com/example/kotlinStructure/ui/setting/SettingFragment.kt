package com.example.kotlinStructure.ui.setting

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.example.kotlinStructure.R
import com.example.kotlinStructure.base.BaseFragment
import com.example.kotlinStructure.data.model.general.RequestHeader
import com.example.kotlinStructure.data.model.loadParameter.LoadParameterResponse
import com.example.kotlinStructure.data.model.loadParameter.LoadParametersRequest
import com.example.kotlinStructure.data.model.token.TokenRequest
import com.example.kotlinStructure.data.model.token.TokenResponse
import com.example.kotlinStructure.data.repository.DBRepository
import com.example.kotlinStructure.enums.ApiStatus
import com.example.kotlinStructure.enums.SettingsViewStates
import com.example.kotlinStructure.enums.SharedPrefKeys
import com.example.kotlinStructure.util.Constants
import com.example.kotlinStructure.util.Resource
import com.example.kotlinStructure.util.SharedPrefHelper
import com.example.kotlinStructure.util.ViewHelper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.setting_fragment.*
import javax.inject.Inject

@AndroidEntryPoint
class SettingFragment : BaseFragment() {

    @Inject
    lateinit var viewHelper: ViewHelper

    @Inject
    lateinit var preference: SharedPrefHelper

    @Inject
    lateinit var dbRepo: DBRepository

    private val viewModel: SettingViewModel by viewModels()

    override fun layoutId(): Int = R.layout.setting_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        saveButton.setOnClickListener(onClickListener())
    }

    private fun onClickListener() = View.OnClickListener { v ->
        run {
            if (v.id == saveButton.id) {
//                setTokenRequest()
                subscribeTokenObserver()
            }
        }
    }

//    private fun setTokenRequest() {
//        viewModel.setTokenRequest(
//            TokenRequest(
//                RequestHeader(terminalIdTextInputLayout.editText!!.text.toString()),
//                terminalIdTextInputLayout.editText!!.text.toString(),
//                passwordTextInputLayout.editText!!.text.toString()
//            )
//        )
//    }

    private fun subscribeTokenObserver() {
        viewModel.getTokenData(
            TokenRequest(
                RequestHeader(terminalIdTextInputLayout.editText!!.text.toString()),
                terminalIdTextInputLayout.editText!!.text.toString(),
                passwordTextInputLayout.editText!!.text.toString()
            )
        ).observe(viewLifecycleOwner, {
            when (it.status) {
                ApiStatus.LOADING -> showLoader()
                ApiStatus.ERROR -> Log.d("TAG", "subscribeTokenObserver: " + it.message)
                ApiStatus.SUCCESS -> {
                    Constants.applicationToken = it.data?.token.toString()
                    setDataToShared(it.data)
                    setLoadParameterRequest()
                }
            }
        })
    }

    private fun setDataToShared(it: TokenResponse?) {
        preference.setStringToShared(SharedPrefKeys.Token.name, it.toString())
        preference.setStringToShared(
            SharedPrefKeys.TerminalId.name,
            terminalIdTextInputLayout.editText!!.text.toString()
        )
        preference.setStringToShared(
            SharedPrefKeys.Password.name,
            passwordTextInputLayout.editText!!.text.toString()
        )
    }

    private fun setLoadParameterRequest() {
        viewModel.setLoadParameterRequest(
            LoadParametersRequest(
                RequestHeader(
                    preference.getStringFromShared(SharedPrefKeys.TerminalId.name),
                    preference.getStringFromShared(SharedPrefKeys.Password.name),
                ), null, preference.getStringFromShared(SharedPrefKeys.Password.name)
            )
        )
        subscribeLoadParameterObserver()
    }

    private fun subscribeLoadParameterObserver() {
        viewModel.getLoadParameterResponse().observe(viewLifecycleOwner, {
            when (it.status) {
                ApiStatus.LOADING -> Log.d("TAG", "subscribeTokenObserver: " + it.status)
                ApiStatus.ERROR -> Log.d("TAG", "subscribeTokenObserver: " + it.message)
                ApiStatus.SUCCESS -> insertTerminalSetting(it)
            }
//            setViewStates(it.status)

        })
    }

    private fun insertTerminalSetting(it: Resource<LoadParameterResponse>) {
        viewModel.insertTerminalSetting(it.data?.getTerminalSetting()).observe(viewLifecycleOwner, {
//            setViewStates(it.status)
        })
    }

    private fun setViewStates(viewStates: SettingsViewStates) {
        when (viewStates) {
            SettingsViewStates.TokenLoading -> TODO()
            SettingsViewStates.TokenSuccess -> TODO()
            SettingsViewStates.TokenFailure -> TODO()
            SettingsViewStates.LoadParameterSUCCESS -> TODO()
            SettingsViewStates.LoadParameterERROR -> TODO()
            SettingsViewStates.LoadParameterLOADING -> TODO()
            SettingsViewStates.InsertTerminalSettingSUCCESS -> TODO()
            SettingsViewStates.InsertTerminalSettingERROR -> TODO()
            SettingsViewStates.InsertTerminalSettingLOADING -> TODO()
        }
    }
}