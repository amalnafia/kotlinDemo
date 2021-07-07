package com.example.kotlinStructure.data.model.token

import com.example.kotlinStructure.data.model.general.ResponseHeader
import com.google.gson.annotations.SerializedName


class TokenResponse {
    @SerializedName("token")
    var token: String?

    @SerializedName("expireDate")
    var expireDate: String?

    @SerializedName("responseHeader")
    private var responseHeader: ResponseHeader?

    constructor(token: String?, expireDate: String?, responseHeader: ResponseHeader?) {
        this.token = token
        this.expireDate = expireDate
        this.responseHeader = responseHeader
    }

}
