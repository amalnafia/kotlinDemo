package com.example.kotlinStructure.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.kotlinStructure.data.model.notification.NotificationSender
import com.example.kotlinStructure.data.model.notification.NotificationTypes
import com.example.kotlinStructure.data.model.sevice.ServiceProvider
import com.example.kotlinStructure.data.model.sevice.Services
import com.example.kotlinStructure.data.model.terminalSetting.TerminalSetting
import io.reactivex.Completable

@Dao
interface DBInterface {

    //TerminalSetting
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTerminalSetting(terminalSetting: TerminalSetting): Completable

    //NotificationSender
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotificationSenderList(notificationSenderList: List<NotificationSender>): Completable

    //NotificationType
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotificationTypeList(notificationTypeList: List<NotificationTypes>): Completable

    //ServiceProvider
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertServiceProviderList(serviceProviderList: List<ServiceProvider>): Completable

    //Services
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertServicesList(servicesList: List<Services>): Completable

}