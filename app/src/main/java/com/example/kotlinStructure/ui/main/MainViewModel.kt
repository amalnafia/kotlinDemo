package com.example.kotlinStructure.ui.main

import androidx.lifecycle.ViewModel
import com.example.kotlinStructure.data.repository.SettingRepository
import com.example.kotlinStructure.module.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val settingRepository: SettingRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

}