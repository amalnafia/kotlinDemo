package com.example.kotlinStructure.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlinStructure.data.model.notification.NotificationSender
import com.example.kotlinStructure.data.model.notification.NotificationTypes
import com.example.kotlinStructure.data.model.sevice.ServiceProvider
import com.example.kotlinStructure.data.model.sevice.Services
import com.example.kotlinStructure.data.model.terminalSetting.TerminalSetting
import com.example.kotlinStructure.data.model.users.UsersManagement
import com.example.kotlinStructure.util.Constants.databaseName

@Database(
    entities = [UsersManagement::class, TerminalSetting::class, ServiceProvider::class, Services::class,
        NotificationTypes::class, NotificationSender::class], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dbInterface(): DBInterface

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE =
                    Room.databaseBuilder(context, AppDatabase::class.java, databaseName)
                        .allowMainThreadQueries().build()
            }
            return INSTANCE as AppDatabase
        }
    }
}