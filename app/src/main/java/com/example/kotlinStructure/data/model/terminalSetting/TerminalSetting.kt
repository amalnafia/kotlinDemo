package com.example.kotlinStructure.data.model.terminalSetting

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "TerminalSetting")
class TerminalSetting {
    @PrimaryKey
    @ColumnInfo(name = "terminalID")
    @SerializedName("terminalID")
    var terminalID: String = null.toString()

    @ColumnInfo(name = "distrbuterID")
    @SerializedName("distrbuterID")
    var distributorID: String? = null

    @ColumnInfo(name = "terminalNameEn")
    @SerializedName("terminalNameEn")
    var terminalNameEn: String? = null

    @ColumnInfo(name = "terminalNameAr")
    @SerializedName("terminalNameAr")
    var terminalNameAr: String? = null

    @ColumnInfo(name = "distrbuterNameEn")
    @SerializedName("distrbuterNameEn")
    var distributorNameEn: String? = null

    @ColumnInfo(name = "distrbuterNameAr")
    @SerializedName("distrbuterNameAr")
    var distributorNameAr: String? = null

    @ColumnInfo(name = "distrbuterMessageEn")
    @SerializedName("distrbuterMessageEn")
    var distributorMessageEn: String? = null

    @ColumnInfo(name = "distrbuterMessageAr")
    @SerializedName("distrbuterMessageAr")
    var distributorMessageAr: String? = null

    @ColumnInfo(name = "distrbuterLogo")
    @SerializedName("distrbuterLogo")
    var distributorLogo: String? = null

    @ColumnInfo(name = "distrbuterVoucherLogo")
    @SerializedName("distrbuterVoucherLogo")
    var distributorVoucherLogo: String? = null

    @ColumnInfo(name = "distrbuterLogoEnable")
    @SerializedName("distrbuterLogoEnable")
    var distributorLogoEnable = 0

    @ColumnInfo(name = "terminalLogo")
    @SerializedName("terminalLogo")
    var terminalLogo: String? = null

    @ColumnInfo(name = "enableOffline")
    @SerializedName("enableOffline")
    var enableOffline = 0

    @ColumnInfo(name = "enableOnline")
    @SerializedName("enableOnline")
    var enableOnline = 0

    @ColumnInfo(name = "enableBillpayment")
    @SerializedName("enableBillpayment")
    var enableBillPayment = 0

    @ColumnInfo(name = "enableTopup")
    @SerializedName("enableTopup")
    var enableTopUp = 0

    @ColumnInfo(name = "maxTotalCardPerOrder")
    @SerializedName("maxTotalCardPerOrder")
    var maxTotalCardPerOrder = 0

    @ColumnInfo(name = "syncEveryServiceCount")
    @SerializedName("syncEveryServiceCount")
    var syncEveryServiceCount = 0

    @ColumnInfo(name = "maxCardPrinting")
    @SerializedName("maxCardPrinting")
    var maxCardPrinting = 0

    @ColumnInfo(name = "enableReprint")
    @SerializedName("enableReprint")
    var enableReprint = 0

    @ColumnInfo(name = "latitude")
    @SerializedName("latitude")
    var latitude: String? = null

    @ColumnInfo(name = "longitude")
    @SerializedName("longitude")
    var longitude: String? = null

    @ColumnInfo(name = "checkGps")
    @SerializedName("checkGps")
    var checkGps = 0

    @ColumnInfo(name = "evBalanceType")
    @SerializedName("evBalanceType")
    var evBalanceType: String? = null

    @ColumnInfo(name = "operatorLogo")
    @SerializedName("operatorLogo")
    var operatorLogo: String? = null

    @ColumnInfo(name = "currency")
    @SerializedName("currency")
    var currency: String? = null

    @ColumnInfo(name = "decimalNo")
    @SerializedName("decimalNo")
    var decimalNo = 0

    @ColumnInfo(name = "maxTotalCardInTerminal")
    @SerializedName("maxTotalCardInTerminal")
    var maxTotalCardInTerminal = 0

    @ColumnInfo(name = "currentTotalCardInTerminal")
    var currentTotalCardInTerminal = 0

    @ColumnInfo(name = "lastUpdatedDate")
    var lastUpdatedDate: String? = null

    @ColumnInfo(name = "passwordChanged")
    @SerializedName("passwordChanged")
    var isPasswordChanged = false

    @ColumnInfo(name = "isLocked")
    var isLocked = false

    @ColumnInfo(name = "reprintLimit")
    @SerializedName("reprintLimit")
    var reprintLimit = 0

    @ColumnInfo(name = "poweredBy")
    @SerializedName("poweredBy")
    var poweredBy: String? = null

    @ColumnInfo(name = "enableQR")
    @SerializedName("enableQR")
    var enableQR = 0
}