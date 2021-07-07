package com.example.kotlinStructure.data.model.loadParameter

import com.example.kotlinStructure.data.model.general.ResponseHeader
import com.example.kotlinStructure.data.model.key.SecurityModel
import com.example.kotlinStructure.data.model.sevice.ServiceProvider
import com.example.kotlinStructure.data.model.sevice.Services
import com.example.kotlinStructure.data.model.terminalSetting.TerminalSetting
import com.google.gson.annotations.SerializedName

class LoadParameterResponse {

    @SerializedName("responseHeader")
    private var responseHeader: ResponseHeader? = null

    @SerializedName("terminalSetting")
    private var terminalSetting: TerminalSetting? = null

    @SerializedName("serviceProviders")
    private var serviceProviders: List<ServiceProvider>? = null

    @SerializedName("services")
    private var services: List<Services>? = null

    @SerializedName("securityKey")
    private var securityKey: SecurityModel? = null

    @SerializedName("lastModifiedDate")
    private var lastModifiedDate: String? = null

    fun getResponseHeader(): ResponseHeader? {
        return responseHeader
    }

    fun getTerminalSetting(): TerminalSetting? {
        return terminalSetting
    }

    fun getServiceProviders(): List<ServiceProvider>? {
        return serviceProviders
    }

    fun getServices(): List<Services>? {
        return services
    }

    fun getSecurityKey(): SecurityModel? {
        return securityKey
    }

    fun getLastModifiedDate(): String? {
        return lastModifiedDate
    }

    fun LoadParametersResponse(
        responseHeader: ResponseHeader?,
        terminalSetting: TerminalSetting?,
        serviceProviders: List<ServiceProvider>?,
        services: List<Services>?,
        securityKey: SecurityModel?,
        lastModifiedDate: String?,
    ) {
        this.responseHeader = responseHeader
        this.terminalSetting = terminalSetting
        this.serviceProviders = serviceProviders
        this.services = services
        this.securityKey = securityKey
        this.lastModifiedDate = lastModifiedDate
    }
}