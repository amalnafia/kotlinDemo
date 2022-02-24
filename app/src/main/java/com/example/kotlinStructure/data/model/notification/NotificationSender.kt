package com.example.kotlinStructure.data.model.notification

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "NotificationSender")
class NotificationSender(
    @field:SerializedName("simnumber") @field:ColumnInfo(
        name = "simnumber"
    ) var simNumber: String,
    @field:SerializedName("isEnable") @field:ColumnInfo(name = "isEnable") var isEnable: Boolean,
    @field:SerializedName(
        "isDeleted"
    ) @field:ColumnInfo(name = "isDeleted") var isDeleted: Boolean
) {
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    var id = 0

}