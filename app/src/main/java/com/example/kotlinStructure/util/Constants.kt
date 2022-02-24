package com.example.kotlinStructure.util

import android.Manifest


object Constants {
    const val requestTimeout = 60L
    const val databaseName = "roomDatabase.db"
    const val sharedPreferenceName = "sharedName"
    var applicationToken = ""

    const val REQUEST_CODE_LOCATION = 1
    const val LOCATION_PERMISSION = Manifest.permission.ACCESS_FINE_LOCATION
}
