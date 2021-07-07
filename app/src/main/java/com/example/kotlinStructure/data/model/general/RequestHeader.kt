package com.example.kotlinStructure.data.model.general

import com.google.gson.annotations.SerializedName

class RequestHeader {
    @SerializedName("ipAddress")
    private var ipAddress = ""

    @SerializedName("accountToken")
    private var accountToken: String

    @SerializedName("notificationToken")
    private var notificationToken: String

    @SerializedName("osversion")
    private var osVersion: String

    @SerializedName("appversion")
    private var appVersion: String

    @SerializedName("languageCode")
    private var languageCode: String

    @SerializedName("terminalId")
    private var terminalId: String

    @SerializedName("simcardNo")
    private var simCardNo: String

    @SerializedName("currencyId")
    private var currencyId = 0

    @SerializedName("sourceType")
    private val sourceType: String? = null

    @SerializedName("currentLocaion")
    private val currentLocation: String? = null

    @SerializedName("password")
    private var password: String? = null

    @SerializedName("serilaNo")
    private var serialNo: String? = null

    @SerializedName("appversionCode")
    private var appVersionCode: Int

    constructor(terminalId: String) {
        currencyId = 0
        notificationToken = ""
        osVersion = ""
        appVersion = ""
        ipAddress = ""
        languageCode = "en"
        this.terminalId = terminalId
        appVersionCode = 1
        simCardNo = ""
        accountToken = ""
        //        this.serialNo = Constants.deviceSerial.equals("") ? new PrefHelper().getStringFromShared(SharedPrefKeys.deviceSerial) : Constants.deviceSerial;
        serialNo = "62903abc"
    }

    constructor(terminalId: String, password: String?=null) {
        currencyId = 0
        notificationToken = ""
        osVersion = ""
        appVersion = ""
        ipAddress = ""
        languageCode = "en"
        this.terminalId = terminalId
        appVersionCode = 1
        simCardNo = ""
        accountToken = ""
        this.password = password
        //        this.serialNo = Constants.deviceSerial.equals("") ? new PrefHelper().getStringFromShared(SharedPrefKeys.deviceSerial) : Constants.deviceSerial;
        this.serialNo = "62903abc";
    }
}