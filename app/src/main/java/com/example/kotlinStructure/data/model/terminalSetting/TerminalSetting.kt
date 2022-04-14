package com.example.kotlinStructure.data.model.terminalSetting

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "TerminalSetting")
data class TerminalSetting(
    @PrimaryKey
    @ColumnInfo(name = "terminalID")
    @SerializedName("terminalID")
    var terminalID: String,

    @ColumnInfo(name = "distributorID")
    @SerializedName("distrbuterID")
    var distributorID: String?,

    @ColumnInfo(name = "terminalNameEn")
    @SerializedName("terminalNameEn")
    var terminalNameEn: String?,

    @ColumnInfo(name = "terminalNameAr")
    @SerializedName("terminalNameAr")
    var terminalNameAr: String?,

    @ColumnInfo(name = "distributorNameEn")
    @SerializedName("distrbuterNameEn")
    var distributorNameEn: String?,

    @ColumnInfo(name = "distributorNameAr")
    @SerializedName("distrbuterNameAr")
    var distributorNameAr: String?,

    @ColumnInfo(name = "distributorMessageEn")
    @SerializedName("distrbuterMessageEn")
    var distributorMessageEn: String?,

    @ColumnInfo(name = "distributorMessageAr")
    @SerializedName("distrbuterMessageAr")
    var distributorMessageAr: String?,

    @ColumnInfo(name = "distributorLogo")
    @SerializedName("distrbuterLogo")
    var distributorLogo: String?,

    @ColumnInfo(name = "distributorVoucherLogo")
    @SerializedName("distrbuterVoucherLogo")
    var distributorVoucherLogo: String?,

    @ColumnInfo(name = "distributorLogoEnable")
    @SerializedName("distrbuterLogoEnable")
    var distributorLogoEnable: Int,

    @ColumnInfo(name = "terminalLogo")
    @SerializedName("terminalLogo")
    var terminalLogo: String?,

    @ColumnInfo(name = "enableOffline")
    @SerializedName("enableOffline")
    var enableOffline: Int,

    @ColumnInfo(name = "enableOnline")
    @SerializedName("enableOnline")
    var enableOnline: Int,

    @ColumnInfo(name = "enableBillPayment")
    @SerializedName("enableBillpayment")
    var enableBillPayment: Int,

    @ColumnInfo(name = "enableTopUp")
    @SerializedName("enableTopup")
    var enableTopUp: Int,

    @ColumnInfo(name = "maxTotalCardPerOrder")
    @SerializedName("maxTotalCardPerOrder")
    var maxTotalCardPerOrder: Int,

    @ColumnInfo(name = "syncEveryServiceCount")
    @SerializedName("syncEveryServiceCount")
    var syncEveryServiceCount: Int,

    @ColumnInfo(name = "maxCardPrinting")
    @SerializedName("maxCardPrinting")
    var maxCardPrinting: Int,

    @ColumnInfo(name = "enableReprint")
    @SerializedName("enableReprint")
    var enableReprint: Int,

    @ColumnInfo(name = "latitude")
    @SerializedName("latitude")
    var latitude: String?,

    @ColumnInfo(name = "longitude")
    @SerializedName("longitude")
    var longitude: String?,

    @ColumnInfo(name = "checkGps")
    @SerializedName("checkGps")
    var checkGps: Int,

    @ColumnInfo(name = "evBalanceType")
    @SerializedName("evBalanceType")
    var evBalanceType: String?,

    @ColumnInfo(name = "operatorLogo")
    @SerializedName("operatorLogo")
    var operatorLogo: String?,

    @ColumnInfo(name = "currency")
    @SerializedName("currency")
    var currency: String?,

    @ColumnInfo(name = "decimalNo")
    @SerializedName("decimalNo")
    var decimalNo: Int,

    @ColumnInfo(name = "maxTotalCardInTerminal")
    @SerializedName("maxTotalCardInTerminal")
    var maxTotalCardInTerminal: Int,

    @ColumnInfo(name = "currentTotalCardInTerminal")
    var currentTotalCardInTerminal: Int,

    @ColumnInfo(name = "lastUpdatedDate")
    var lastUpdatedDate: String?,

    @ColumnInfo(name = "passwordChanged")
    @SerializedName("passwordChanged")
    var isPasswordChanged: Boolean,

    @ColumnInfo(name = "isLocked")
    var isLocked: Boolean,

    @ColumnInfo(name = "reprintLimit")
    @SerializedName("reprintLimit")
    var reprintLimit: Int,

    @ColumnInfo(name = "poweredBy")
    @SerializedName("poweredBy")
    var poweredBy: String?,

    @ColumnInfo(name = "enableQR")
    @SerializedName("enableQR")
    var enableQR: Int,

    @ColumnInfo(name = "enableResetLimit")
    @SerializedName("enableResetLimit")
    var enableResetLimit: Int
)