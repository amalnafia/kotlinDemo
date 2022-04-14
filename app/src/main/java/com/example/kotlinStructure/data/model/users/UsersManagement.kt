package com.example.kotlinStructure.data.model.users

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "UsersManagement")
data class UsersManagement(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @SerializedName("id")
    var id: Int,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    var name: String,

    @ColumnInfo(name = "passsword")
    @SerializedName("password")
    var password: String,

    @ColumnInfo(name = "purchaseOffline")
    @SerializedName("purchaseOffline")
    var purchaseOffline: Int,

    @ColumnInfo(name = "purchaseOnline")
    @SerializedName("purchaseOnline")
    var purchaseOnline: Int,

    @ColumnInfo(name = "topup")
    @SerializedName("topup")
    var topUp: Int,

    @ColumnInfo(name = "billpayment")
    @SerializedName("billpayment")
    var billPayment: Int,

    @ColumnInfo(name = "salesReport")
    @SerializedName("salesReport")
    var salesReport: Int,

    @ColumnInfo(name = "createdDate")
    @SerializedName("createdDate")
    var createdDate: String,

    @ColumnInfo(name = "lastUpdateDate")
    @SerializedName("lastUpdateDate")
    var lastUpdateDate: String,

    @ColumnInfo(name = "isAdmin")
    var isAdmin: Boolean,
    @ColumnInfo(name = "isActive")
    var isActive: Boolean,

    @ColumnInfo(name = "forceLogout")
    var isForceLogout: Boolean,

    @ColumnInfo(name = "resetLimit")
    var resetLimit: Int,

    @ColumnInfo(name = "myBalance")
    var myBalance: Int,

    @ColumnInfo(name = "checkLastTransaction")
    var checkLastTransaction: Int
)