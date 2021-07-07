package com.example.kotlinStructure.data.model.general

import com.google.gson.annotations.SerializedName

class ResponseHeader {

    @SerializedName("version")
    private val version: String? = null

    @SerializedName("statusCode")
    private val statusCode = 0

    @SerializedName("requestId")
    private val requestId: String? = null

    @SerializedName("error")
    private val error: List<String?>? = null

    @SerializedName("success")
    private val success = false

    @SerializedName("message")
    private val message: String? = null

    fun getVersion(): String? {
        return version
    }

    fun getStatusCode(): Int {
        return statusCode
    }

    fun getRequestId(): String? {
        return requestId
    }

    fun getError(): List<String?>? {
        return error
    }

    fun isSuccess(): Boolean {
        return success
    }

    fun getMessage(): String? {
        return message
    }

}