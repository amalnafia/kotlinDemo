package com.example.kotlinStructure.ui.setting

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.kotlinStructure.R
import com.example.kotlinStructure.base.BaseFragment
import com.example.kotlinStructure.data.model.general.RequestHeader
import com.example.kotlinStructure.data.model.token.TokenRequest
import com.example.kotlinStructure.util.SharedPrefHelper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.setting_fragment.*
import javax.inject.Inject

@AndroidEntryPoint
class SettingFragment : BaseFragment() {

    private val viewModel: SettingViewModel by viewModels()

    @Inject
    lateinit var preference: SharedPrefHelper

    override fun layoutId(): Int = R.layout.setting_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        saveButton.setOnClickListener { subscribeTokenObserver() }
    }

    private fun subscribeTokenObserver() {
        viewModel.getToken(
            TokenRequest(
                RequestHeader(terminalIdTextInputLayout.editText!!.text.toString()),
                terminalIdTextInputLayout.editText!!.text.toString(),
                passwordTextInputLayout.editText!!.text.toString()
            )
        ).observe(viewLifecycleOwner) {

        }
    }


}