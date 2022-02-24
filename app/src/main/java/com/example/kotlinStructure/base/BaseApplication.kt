package com.example.kotlinStructure.base

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LifecycleObserver
import com.example.kotlinStructure.util.Constants.sharedPreferenceName
import dagger.hilt.android.HiltAndroidApp
import io.reactivex.exceptions.UndeliverableException
import io.reactivex.plugins.RxJavaPlugins

@HiltAndroidApp
class BaseApplication : Application(), LifecycleObserver {
    companion object {
        lateinit var baseApplication: BaseApplication
        lateinit var sharedPreferences: SharedPreferences
    }

    override fun onCreate() {
        super.onCreate()
        baseApplication = this

        rxError()
        sharedPreferences = applicationContext.getSharedPreferences(
            sharedPreferenceName, Context.MODE_PRIVATE
        )
    }

    private fun rxError() {
        RxJavaPlugins.setErrorHandler { e ->
            when (e) {
                is UndeliverableException -> {
                    Log.e("TAG", "onCreate: ", e)
                }
                else -> {
                    Thread.currentThread().also { thread ->
                        thread.uncaughtExceptionHandler.uncaughtException(thread, e)
                    }
                }
            }
        }
    }
}