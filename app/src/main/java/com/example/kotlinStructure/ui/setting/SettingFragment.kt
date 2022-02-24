package com.example.kotlinStructure.ui.setting

import android.app.NotificationManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.example.kotlinStructure.R
import com.example.kotlinStructure.base.BaseFragment
import com.example.kotlinStructure.data.model.general.RequestHeader
import com.example.kotlinStructure.data.model.loadParameter.LoadParameterResponse
import com.example.kotlinStructure.data.model.loadParameter.LoadParametersRequest
import com.example.kotlinStructure.data.model.token.TokenRequest
import com.example.kotlinStructure.data.model.token.TokenResponse
import com.example.kotlinStructure.enums.ApiStatus.*
import com.example.kotlinStructure.enums.RoomStatus
import com.example.kotlinStructure.enums.SharedPrefKeys
import com.example.kotlinStructure.util.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.setting_fragment.*
import javax.inject.Inject

@AndroidEntryPoint
class SettingFragment : BaseFragment() {

    @Inject
    lateinit var viewHelper: ViewHelper

    @Inject
    lateinit var preference: SharedPrefHelper

    private val viewModel: SettingViewModel by viewModels()

    override fun layoutId(): Int = R.layout.setting_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cancelAllNotifications()
        createChannel()

        saveButton.setOnClickListener { subscribeTokenObserver() }
    }


    public fun subscribeTokenObserverTest(tokenRequest: TokenRequest): Boolean {
        var bool = false
        viewModel.getTokenData(
            tokenRequest
        ).observe(viewLifecycleOwner, {
            when (it.status) {
                LOADING -> showLoader()
                NOINTERNET -> navigateToNoInternet()
                ERROR -> {
                    dismissLoader()
                    Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                    Log.d("TAG", "subscribeTokenObserver: " + it.message)
                    bool = false
                }
                SUCCESS -> {
                    bool = true
                    Log.d("TAG", "subscribeTokenObserver: ")
//                    Constants.applicationToken = it.data?.token.toString()
//                    setDataToShared(it.data)
//                    subscribeLoadParameterObserver()
                }
            }
        })
        return bool
    }

    private fun createChannel() {
        createNotificationChannel(getString(R.string.done_notification_channel_id),
            getString(R.string.done_notification_channel_name), requireContext())
    }

    private fun cancelAllNotifications() {
        val notificationManager = ContextCompat.getSystemService(
            requireContext(), NotificationManager::class.java) as NotificationManager
        notificationManager.cancelNotifications()
    }

    private fun subscribeTokenObserver() {
        viewModel.getTokenData(
            TokenRequest(
                RequestHeader(terminalIdTextInputLayout.editText!!.text.toString()),
                terminalIdTextInputLayout.editText!!.text.toString(),
                passwordTextInputLayout.editText!!.text.toString()
            )
        ).observe(viewLifecycleOwner, {
            when (it.status) {
                LOADING -> showLoader()
                NOINTERNET -> navigateToNoInternet()
                ERROR -> {
                    dismissLoader()
                    Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                    Log.d("TAG", "subscribeTokenObserver: " + it.message)
                }
                SUCCESS -> {
                    Log.d("TAG", "subscribeTokenObserver: ")
                    subscribeLoadParameterObserver()
//                    Constants.applicationToken = it.data?.token.toString()
//                    setDataToShared(it.data)
//                    subscribeLoadParameterObserver()
                }
            }
        })
    }

    private fun setDataToShared(it: TokenResponse?) {
        preference.setStringToShared(SharedPrefKeys.Token.name, it.toString())
        preference.setStringToShared(
            SharedPrefKeys.TerminalId.name, terminalIdTextInputLayout.editText!!.text.toString()
        )
        preference.setStringToShared(
            SharedPrefKeys.Password.name, passwordTextInputLayout.editText!!.text.toString()
        )
    }

        private fun subscribeLoadParameterObserver() {
            viewModel.getLoadParameterResponse(
                LoadParametersRequest(
                    RequestHeader(
                        preference.getStringFromShared(SharedPrefKeys.TerminalId.name),
                        preference.getStringFromShared(SharedPrefKeys.Password.name)
                    ), null, preference.getStringFromShared(SharedPrefKeys.Password.name)
                )
            ).observe(viewLifecycleOwner, {
                when (it.status) {
                    LOADING -> Log.d("TAG", "subscribeTokenObserver: " + it.status)
                    ERROR -> Log.d("TAG", "subscribeTokenObserver: " + it.message)
                    SUCCESS -> insertAllLoadParameters(it)
                    NOINTERNET -> navigateToNoInternet()
                }
            })
        }

    private fun insertAllLoadParameters(it: Resource<LoadParameterResponse>) {
        viewModel.insertAllLoadParameters(it.data!!)
            .observe(viewLifecycleOwner, {
                when (it.status) {
                    RoomStatus.LOADING -> Log.d("TAG", "subscribeTokenObserver: " + it.status)
                    RoomStatus.ERROR -> Log.d("TAG", "subscribeTokenObserver: " + it.message)
                    RoomStatus.SUCCESS -> {
                        sendNotification()
                        dismissLoader()
                        navigateTo(R.id.action_settingFragment_to_mapsFragment)
                    }
                }
            })
    }

    private fun sendNotification() {
        val notificationManager = ContextCompat.getSystemService(
            requireContext(), NotificationManager::class.java
        ) as NotificationManager
        notificationManager.sendNotification("All App configurations are added", requireContext())
    }
}