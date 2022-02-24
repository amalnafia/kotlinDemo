package com.example.kotlinStructure.data.model.loadParameter

import com.example.kotlinStructure.data.model.general.ResponseHeader
import com.example.kotlinStructure.data.model.key.SecurityModel
import com.example.kotlinStructure.data.model.notification.NotificationSender
import com.example.kotlinStructure.data.model.notification.NotificationTypes
import com.example.kotlinStructure.data.model.sevice.ServiceProvider
import com.example.kotlinStructure.data.model.sevice.Services
import com.example.kotlinStructure.data.model.terminalSetting.TerminalSetting
import com.google.gson.annotations.SerializedName

class LoadParameterResponse(
    responseHeader: ResponseHeader?,
    terminalSetting: TerminalSetting?,
    serviceProviders: List<ServiceProvider>?,
    services: List<Services>?,
    securityKey: SecurityModel?,
    lastModifiedDate: String?,
    notificationTypes: List<NotificationTypes>?,
    notificationSender: List<NotificationSender>?,
) {

    @SerializedName("responseHeader")
    var responseHeader: ResponseHeader? = responseHeader
        private set

    @SerializedName("terminalSetting")
    var terminalSetting: TerminalSetting? = terminalSetting
        private set

    @SerializedName("serviceProviders")
    var serviceProviders: List<ServiceProvider>? = serviceProviders
        private set

    @SerializedName("services")
    var services: List<Services>? = services
        private set

    @SerializedName("securityKey")
    var securityKey: SecurityModel? = securityKey
        private set

    @SerializedName("lastModifiedDate")
    var lastModifiedDate: String? = lastModifiedDate
        private set

    @SerializedName("notificationTypes")
    var notificationTypes: List<NotificationTypes>? = notificationTypes
        private set

    @SerializedName("notificationSenders")
     var notificationSenders: List<NotificationSender>? = notificationSender
        private set
}
