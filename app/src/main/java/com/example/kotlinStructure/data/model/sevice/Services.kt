package com.example.kotlinStructure.data.model.sevice

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "Services")
data class Services(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    var id: Int = 0,

    @ColumnInfo(name = "serviceProviderID")
    @SerializedName("serviceProviderID")
    var serviceProviderID: Int = 0,

    @ColumnInfo(name = "nameEn")
    @SerializedName("nameEn")
    var nameEn: String? = null,

    @ColumnInfo(name = "nameAr")
    @SerializedName("nameAr")
    var nameAr: String? = null,

    @ColumnInfo(name = "logo")
    @SerializedName("logo")
    var logo: String? = null,

    @ColumnInfo(name = "voucherLogo")
    @SerializedName("voucherLogo")
    var voucherLogo: String? = null,

    @ColumnInfo(name = "voucherMessageEn")
    @SerializedName("voucherMessageEn")
    var voucherMessageEn: String? = null,

    @ColumnInfo(name = "voucherMessageAr")
    @SerializedName("voucherMessageAr")
    var voucherMessageAr: String? = null,

    @ColumnInfo(name = "maxcardPerOrder")
    @SerializedName("maxcardPerOrder")
    var maxcardPerOrder: Int = 0,

    @ColumnInfo(name = "amount")
    @SerializedName("amount")
    var amount: Double = 0.0,

    @ColumnInfo(name = "commission")
    @SerializedName("commission")
    var commission: Double = 0.0,

    @ColumnInfo(name = "reorderLevel")
    @SerializedName("reorderLevel")
    var reorderLevel: Int = 0,

    @ColumnInfo(name = "tax")
    @SerializedName("tax")
    var tax: Double = 0.0,

    @ColumnInfo(name = "reorderAmount")
    @SerializedName("reorderAmount")
    var reorderAmount: Int = 0,

    @ColumnInfo(name = "serviceCode")
    @SerializedName("serviceCode")
    var serviceCode: String? = null,

    @ColumnInfo(name = "eVRePrint")
    @SerializedName("eVRePrint")
    var rePrint: Int = 0,

    @ColumnInfo(name = "eVMaxCardPrinting")
    @SerializedName("eVMaxCardPrinting")
    var maxCardPrinting: Int = 0,

    @ColumnInfo(name = "offlineMinOrder")
    @SerializedName("offlineMinOrder")
    var offlineMinOrder: Int = 0,

    @ColumnInfo(name = "isOffline")
    @SerializedName("isOffline")
    var isOffline: Int = 0,
    @ColumnInfo(name = "isOnline")
    @SerializedName("isOnline")
    var isOnline: Int = 0,

    @ColumnInfo(name = "isPinCode")
    @SerializedName("isPinCode")
    var isPinCode: Int = 0,

    @ColumnInfo(name = "sortNo")
    @SerializedName("sortNo")
    var sortNo: Int = 0,

    @ColumnInfo(name = "lastModifiedDate")
    @SerializedName("lastModifiedDate")
    var lastModifiedDate: String? = null,

    @ColumnInfo(name = "isEnable")
    @SerializedName("isEnable")
    var isEnable: Boolean = false,

    @ColumnInfo(name = "isDeleted")
    @SerializedName("isDeleted")
    var isDeleted: Boolean = false,

    @ColumnInfo(name = "distrbuter_FK_ID")
    @SerializedName("distrbuter_FK_ID")
    var distributorFkId: String? = null,

    @SerializedName("evServiceProvider_FK_ID")
    var evServiceProvider_FK_ID: Int = 0,

    @ColumnInfo(name = "voucherLogoBase64")
    var voucherLogoBase64: String? = null,

//My Balance API
    @SerializedName("currentBalance")
    var currentBalance: Int = 0,

    @SerializedName("evService_FK_ID")
    var evService_FK_ID: Int = 0,

    @SerializedName("serviceLogo")
    var serviceLogo: String? = null,

//For Query
    @ColumnInfo(name = "cardCount")
    var cardCount: Int = 0,

    @ColumnInfo(name = "voucherQuickCode")
    @SerializedName("voucherQuickCode")
    var voucherQuickCode: String?
)