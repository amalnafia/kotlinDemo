package com.example.kotlinStructure.data.model.notification

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "notificationTypes")
data class NotificationTypes(
    @field:PrimaryKey
    @field:ColumnInfo(name = "id")
    @field:SerializedName("id")
    var id: Int,

    @field:SerializedName("name")
    @field:ColumnInfo(name = "name")
    var name: String?,

    @field:SerializedName("description")
    @field:ColumnInfo(name = "description")
    var description: String?,

    @field:SerializedName("code")
    @field:ColumnInfo(name = "code")
    var code: String?,

    @field:SerializedName("bodytemplet")
    @field:ColumnInfo(name = "bodytemplet")
    var bodyTemplate: String?
)