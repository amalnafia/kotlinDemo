package com.example.kotlinStructure.module

import com.example.kotlinStructure.BuildConfig
import com.example.kotlinStructure.data.api.ApiInterface
import com.example.kotlinStructure.util.Constants.applicationToken
import com.example.kotlinStructure.util.Constants.requestTimeout
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideBaseUrl() = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(provideBaseUrl())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(getOkHttp())
            .build()

    private fun getOkHttp(): OkHttpClient {
        return if (applicationToken == "")
            provideOkHttpClient()
        else
            getOkHttpWithAuth()
    }

    @Provides
    @Singleton
    fun provideApiInterface(): ApiInterface {
        return provideRetrofit().create(ApiInterface::class.java)
    }


    @Singleton
    private fun getOkHttpWithAuth(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
//        okHttpClient.authenticator { _, response ->
//            response.request.newBuilder().header(
//                "Authorization",
//                "Bearer $applicationToken"
//            ).build()
//        }
        okHttpClient.readTimeout(requestTimeout, TimeUnit.SECONDS)
            .connectTimeout(requestTimeout, TimeUnit.SECONDS)
            .writeTimeout(requestTimeout, TimeUnit.SECONDS)
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        okHttpClient.addInterceptor(httpLoggingInterceptor)
        return okHttpClient.build()
    }
}