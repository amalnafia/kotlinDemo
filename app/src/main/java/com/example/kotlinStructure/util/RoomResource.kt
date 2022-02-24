package com.example.kotlinStructure.util

import com.example.kotlinStructure.enums.RoomStatus

data class RoomResource<out T>(val status: RoomStatus, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T?): RoomResource<T> {
            return RoomResource(RoomStatus.SUCCESS, data, null)
        }

        fun <T> error(msg: String): RoomResource<T> {
            return RoomResource(RoomStatus.ERROR, null, msg)
        }

        fun <T> loading(): RoomResource<T> {
            return RoomResource(RoomStatus.LOADING, null, null)
        }
    }
}