package com.example.kotlinStructure.data.model.token

import com.example.kotlinStructure.data.model.general.RequestHeader
import com.google.gson.annotations.SerializedName


class TokenRequest {
    @SerializedName("requestHeader")
    private val request: RequestHeader

    @SerializedName("terminalId")
    private val terminalId: String

    @SerializedName("password")
    private val password: String

    constructor(request: RequestHeader, terminalId: String, password: String) {
        this.request = request
        this.terminalId = terminalId
        this.password = password
    }
}
