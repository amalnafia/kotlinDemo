package com.example.kotlinStructure.util

import android.content.SharedPreferences
import com.example.kotlinStructure.base.BaseApplication

class SharedPrefHelper {

    private var preferences: SharedPreferences = BaseApplication.sharedPreferences

    fun setStringToShared(key: String, value: String) {
        preferences[key] = value
    }

    fun getStringFromShared(key: String): String {
        return preferences[key] ?: ""
    }

    fun setIntToShared(key: String, value: Int) {
        preferences[key] = value
    }

    fun getIntFromShared(key: String): Int {
        return preferences[key] ?: -1
    }

    fun setBooleanToShared(key: String, value: Boolean) {
        preferences[key] = value
    }

    fun getBooleanFromShared(key: String): Boolean {
        return preferences[key] ?: false
    }
}

private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
    val editor = this.edit()
    operation(editor)
    editor.apply()
}

private operator fun SharedPreferences.set(key: String, value: Any?) {
    when (value) {
        is String? -> edit { it.putString(key, value) }
        is Int -> edit { it.putInt(key, value) }
        is Boolean -> edit { it.putBoolean(key, value) }
        is Float -> edit { it.putFloat(key, value) }
        is Long -> edit { it.putLong(key, value) }
        else -> throw UnsupportedOperationException("Not yet implemented")
    }
}

private inline operator fun <reified T : Any> SharedPreferences.get(
    key: String,
    defaultValue: T? = null
): T? {
    return when (T::class) {
        String::class -> getString(key, defaultValue as? String) as T?
        Int::class -> getInt(key, defaultValue as? Int ?: -1) as T?
        Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as T?
        Float::class -> getFloat(key, defaultValue as? Float ?: -1f) as T?
        Long::class -> getLong(key, defaultValue as? Long ?: -1) as T?
        else -> throw UnsupportedOperationException("Not yet implemented")
    }
}