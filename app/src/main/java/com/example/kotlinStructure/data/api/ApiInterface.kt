package com.example.kotlinStructure.data.api

import com.example.kotlinStructure.data.model.loadParameter.LoadParametersRequest
import com.example.kotlinStructure.data.model.loadParameter.LoadParametersResponse
import com.example.kotlinStructure.data.model.token.TokenRequest
import com.example.kotlinStructure.data.model.token.TokenResponse
import com.example.kotlinStructure.util.Constants
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {

    @POST("Authorize/GetToken")
    suspend fun getToken(@Body request: TokenRequest): TokenResponse

    @POST("Setting/LoadParamters")
    suspend fun getLoadParameters(
        @Body request: LoadParametersRequest,
        @Header("Authorization") header: String = "Bearer ${Constants.applicationToken}"
    ): LoadParametersResponse
}