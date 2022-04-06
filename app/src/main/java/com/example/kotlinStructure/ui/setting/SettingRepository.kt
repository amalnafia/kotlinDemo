package com.example.kotlinStructure.ui.setting

import com.example.kotlinStructure.data.api.ApiInterface
import com.example.kotlinStructure.data.model.token.TokenRequest
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingRepository @Inject constructor(
    private val apiInterface: ApiInterface
) {
    suspend fun getToken(request: TokenRequest) = apiInterface.getToken(request)
}