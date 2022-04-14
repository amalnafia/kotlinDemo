package com.example.kotlinStructure.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.kotlinStructure.data.model.notification.NotificationSender
import com.example.kotlinStructure.data.model.notification.NotificationTypes
import com.example.kotlinStructure.data.model.sevice.ServiceProvider
import com.example.kotlinStructure.data.model.sevice.Services
import com.example.kotlinStructure.data.model.terminalSetting.TerminalSetting
import com.example.kotlinStructure.data.model.users.UsersManagement

@Dao
interface DBInterface {

    //UserManagement
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsersManagement(usersManagement: UsersManagement)

    //TerminalSetting
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTerminalSetting(terminalSetting: TerminalSetting)

    //NotificationSender
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotificationSenderList(notificationSenderList: List<NotificationSender>)

    //NotificationType
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotificationTypeList(notificationTypeList: List<NotificationTypes>)

    //ServiceProvider
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertServiceProviderList(serviceProviderList: List<ServiceProvider>)

    //Services
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertServicesList(servicesList: List<Services>)

}