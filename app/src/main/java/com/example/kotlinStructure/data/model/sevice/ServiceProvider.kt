package com.example.kotlinStructure.data.model.sevice

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "ServiceProvider")
class ServiceProvider {
    @SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey
    var id: Int

    @SerializedName("nameEn")
    @ColumnInfo(name = "nameEn")
    var nameEn: String

    @SerializedName("nameAr")
    @ColumnInfo(name = "nameAr")
    var nameAr: String

    @SerializedName("logo")
    @ColumnInfo(name = "logo")
    var logo: String

    @SerializedName("voucherLogo")
    @ColumnInfo(name = "voucherLogo")
    var voucherLogo: String

    @SerializedName("voucherMessageEn")
    @ColumnInfo(name = "voucherMessageEn")
    var voucherMessageEn: String

    @SerializedName("voucherMessageAr")
    @ColumnInfo(name = "voucherMessageAr")
    var voucherMessageAr: String

    @SerializedName("sortNo")
    @ColumnInfo(name = "sortNo")
    var sortNo: Int

    @SerializedName("lastUpdatedDate")
    @ColumnInfo(name = "lastUpdatedDate")
    var lastUpdatedDate: String

    @SerializedName("isEnable")
    @ColumnInfo(name = "isEnable")
    var isEnable: Boolean

    @SerializedName("isDeleted")
    @ColumnInfo(name = "isDeleted")
    var isDeleted: Boolean

    @ColumnInfo(name = "servicesCount")
    var servicesCount: Int

    @ColumnInfo(name = "voucherQuickCode")
    @SerializedName("voucherQuickCode")
    var voucherQuickCode: String

    constructor(
        id: Int,
        nameEn: String,
        nameAr: String,
        logo: String,
        voucherLogo: String,
        voucherMessageEn: String,
        voucherMessageAr: String,
        sortNo: Int,
        lastUpdatedDate: String,
        isEnable: Boolean,
        isDeleted: Boolean,
        servicesCount: Int,
        voucherQuickCode: String
    ) {
        this.id = id
        this.nameEn = nameEn
        this.nameAr = nameAr
        this.logo = logo
        this.voucherLogo = voucherLogo
        this.voucherMessageEn = voucherMessageEn
        this.voucherMessageAr = voucherMessageAr
        this.sortNo = sortNo
        this.lastUpdatedDate = lastUpdatedDate
        this.isEnable = isEnable
        this.isDeleted = isDeleted
        this.servicesCount = servicesCount
        this.voucherQuickCode = voucherQuickCode
    }
}