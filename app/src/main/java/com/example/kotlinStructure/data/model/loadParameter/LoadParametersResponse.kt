package com.example.kotlinStructure.data.model.loadParameter

import com.example.kotlinStructure.data.model.general.ResponseHeader
import com.example.kotlinStructure.data.model.notification.NotificationSender
import com.example.kotlinStructure.data.model.notification.NotificationTypes
import com.example.kotlinStructure.data.model.sevice.ServiceProvider
import com.example.kotlinStructure.data.model.sevice.Services
import com.example.kotlinStructure.data.model.terminalSetting.TerminalSetting
import com.google.gson.annotations.SerializedName

data class LoadParametersResponse(
    @SerializedName("responseHeader")
    var responseHeader: ResponseHeader?,
    @SerializedName("terminalSetting")
    var terminalSetting: TerminalSetting,
    @SerializedName("serviceProviders")
    var serviceProviders: List<ServiceProvider>,
    @SerializedName("services")
    var services: List<Services>,
    @SerializedName("lastModifiedDate")
    var lastModifiedDate: String,
    @SerializedName("notificationTypes")
    var notificationTypes: List<NotificationTypes>,
    @SerializedName("notificationSenders")
    var notificationSenders: List<NotificationSender>,
)
