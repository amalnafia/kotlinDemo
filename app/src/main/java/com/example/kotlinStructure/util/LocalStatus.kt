package com.example.kotlinStructure.util

sealed class LocalStatus(val message: String? = null) {
    class Success() : LocalStatus()
    class Error(message: String) : LocalStatus(message)
}