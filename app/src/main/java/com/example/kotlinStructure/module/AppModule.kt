package com.example.kotlinStructure.module

import android.content.Context
import com.example.kotlinStructure.base.BaseApplication
import com.example.kotlinStructure.data.api.ApiInterface
import com.example.kotlinStructure.data.room.AppDatabase
import com.example.kotlinStructure.ui.dialog.CircleLoaderDialogFragment
import com.example.kotlinStructure.ui.setting.SettingRepository
import com.example.kotlinStructure.util.SharedPrefHelper
import com.example.kotlinStructure.util.ViewHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideNetworkModule(): NetworkModule {
        return NetworkModule()
    }

    @Singleton
    @Provides
    fun provideViewHelper(): ViewHelper {
        return ViewHelper()
    }

    @Singleton
    @Provides
    fun provideCircleLoaderDialogFragment(): CircleLoaderDialogFragment {
        return CircleLoaderDialogFragment()
    }

    @Singleton
    @Provides
    fun provideAppDatabase(): AppDatabase {
        return AppDatabase.getInstance(provideContext())
    }

    @Singleton
    @Provides
    fun provideContext(): Context {
        return BaseApplication.baseApplication
    }

    @Singleton
    @Provides
    fun provideSharedPrefHelper(): SharedPrefHelper {
        return SharedPrefHelper()
    }

    @Singleton
    @Provides
    fun provideSettingRepository(apiInterface: ApiInterface): SettingRepository {
        return SettingRepository(apiInterface, provideAppDatabase().dbInterface())
    }
}