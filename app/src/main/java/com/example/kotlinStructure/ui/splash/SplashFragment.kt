package com.example.kotlinStructure.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.kotlinStructure.R
import com.example.kotlinStructure.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.splash_fragment.*

@AndroidEntryPoint
class SplashFragment : BaseFragment() {

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View =
        inflater.inflate(R.layout.splash_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        splashView.showContextMenu()
//        SplashFragmentDirections.actionSplashFragmentToSettingFragment(AppName = "")
        Handler().postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_settingFragment)
            splashView.visibility = View.GONE
        }, 3000)
    }
}