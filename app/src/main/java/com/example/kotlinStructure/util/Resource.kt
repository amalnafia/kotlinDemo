package com.example.kotlinStructure.util

import com.example.kotlinStructure.enums.ApiStatus

data class Resource<out T>(val status: ApiStatus, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(ApiStatus.SUCCESS, data, null)
        }

        fun <T> error(msg: String): Resource<T> {
            return Resource(ApiStatus.ERROR, null, msg)
        }

        fun <T> loading(): Resource<T> {
            return Resource(ApiStatus.LOADING, null, null)
        }
    }
}