package com.example.kotlinStructure.data.api

import com.example.kotlinStructure.data.model.loadParameter.LoadParameterResponse
import com.example.kotlinStructure.data.model.loadParameter.LoadParametersRequest
import com.example.kotlinStructure.data.model.token.TokenRequest
import com.example.kotlinStructure.data.model.token.TokenResponse
import com.example.kotlinStructure.util.Constants
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {

    @POST("Authorize/GetToken")
    fun getToken(@Body request: TokenRequest): Observable<TokenResponse>

    @POST("Setting/LoadParamters")
    fun getLoadParameters(
        @Body request: LoadParametersRequest,
        @Header("Authorization") header: String = "Bearer ${Constants.applicationToken}"
    ): Observable<LoadParameterResponse>

}