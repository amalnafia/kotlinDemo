package com.example.kotlinStructure.data.model.general

import com.google.gson.annotations.SerializedName

data class ResponseHeader(
    @SerializedName("version")
    var version: String,
    @SerializedName("statusCode")
    var statusCode: Int,
    @SerializedName("requestId")
    var requestId: String,
    @SerializedName("error")
    var error: List<String>,
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("message")
    var message: String
)