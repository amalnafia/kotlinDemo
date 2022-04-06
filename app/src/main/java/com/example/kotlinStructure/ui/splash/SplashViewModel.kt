package com.example.kotlinStructure.ui.splash

import androidx.lifecycle.ViewModel
import com.example.kotlinStructure.data.repository.SettingRepositoryOld
import com.example.kotlinStructure.module.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val settingRepositoryOld: SettingRepositoryOld,
    private val networkHelper: NetworkHelper
) : ViewModel() {

}