package com.example.kotlinStructure.module

import android.content.Context
import com.example.kotlinStructure.data.repository.DBRepository
import com.example.kotlinStructure.data.room.AppDatabase
import com.example.kotlinStructure.ui.dialog.CircleLoaderDialogFragment
import com.example.kotlinStructure.util.SharedPrefHelper
import com.example.kotlinStructure.util.ViewHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideApiInterface(): NetworkModule {
        return NetworkModule()
    }

    @Singleton
    @Provides
    fun provideViewHelper(): ViewHelper {
        return ViewHelper()
    }

    //    @Singleton
//    @Provides
//    fun provideContext(): Context {
//        return BaseApplication().getContext()
//    }

    @Singleton
    @Provides
    fun provideCircleLoaderDialogFragment(): CircleLoaderDialogFragment {
        return CircleLoaderDialogFragment()
    }

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideDBRepo(@ApplicationContext context: Context): DBRepository {
        return DBRepository(provideAppDatabase(context).dbInterface(), context)
    }

    @Singleton
    @Provides
    fun provideSharedPrefHelper(): SharedPrefHelper {
        return SharedPrefHelper()
    }
}