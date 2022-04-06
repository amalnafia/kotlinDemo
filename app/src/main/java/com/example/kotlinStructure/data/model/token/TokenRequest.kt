package com.example.kotlinStructure.data.model.token

import com.example.kotlinStructure.data.model.general.RequestHeader
import com.google.gson.annotations.SerializedName


data class TokenRequest(
    @SerializedName("requestHeader")
    private val request: RequestHeader,

    @SerializedName("terminalId")
    private val terminalId: String,

    @SerializedName("password")
    private val password: String,
)
