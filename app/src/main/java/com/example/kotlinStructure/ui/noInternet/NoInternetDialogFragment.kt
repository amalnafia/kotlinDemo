package com.example.kotlinStructure.ui.noInternet

import android.os.Bundle
import android.view.View
import com.example.kotlinStructure.R
import com.example.kotlinStructure.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_no_internet.*

@AndroidEntryPoint
class NoInternetDialogFragment : BaseFragment() {

    override fun layoutId(): Int = R.layout.fragment_no_internet

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noInternetButton.setOnClickListener {
            popBack()
        }
    }

}