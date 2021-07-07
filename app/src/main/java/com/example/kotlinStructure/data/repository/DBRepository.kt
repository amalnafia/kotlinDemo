package com.example.kotlinStructure.data.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MediatorLiveData
import com.example.kotlinStructure.data.model.terminalSetting.TerminalSetting
import com.example.kotlinStructure.data.room.DBInterface
import com.example.kotlinStructure.util.Resource
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DBRepository @Inject constructor(
    private val dbInterface: DBInterface?,
    val context: Context
) {
    private val insertTerminalSettingMediator: MediatorLiveData<Resource<Any>> =
        MediatorLiveData<Resource<Any>>()

    //TerminalSetting
    fun insertTerminalSetting(terminalSetting: TerminalSetting?): MediatorLiveData<Resource<Any>> {
        insertTerminalSettingMediator.value = Resource.loading()
        dbInterface!!.insertTerminalSetting(terminalSetting)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : CompletableObserver {
                override fun onSubscribe(d: Disposable) {}
                override fun onComplete() {
                    insertTerminalSettingMediator.value = Resource.success(null)
                }

                override fun onError(e: Throwable) {
                    insertTerminalSettingMediator.value = Resource.error("Error " + e.message)
                    Log.e("", "onError: ", e)
                }
            })
        return insertTerminalSettingMediator
    }
}