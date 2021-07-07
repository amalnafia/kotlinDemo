package com.example.kotlinStructure.data.model.loadParameter

import com.example.kotlinStructure.data.model.general.RequestHeader
import com.google.gson.annotations.SerializedName


data class LoadParametersRequest(
    @SerializedName("requestHeader")
    var request: RequestHeader,

    @SerializedName("lastModifiedDate")
    var lastModifiedDate: String?,

    @SerializedName("password")
    var password: String?=null
)