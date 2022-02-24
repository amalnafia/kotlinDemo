package com.example.kotlinStructure.data.repository


import com.example.kotlinStructure.data.api.ApiInterface
import com.example.kotlinStructure.data.model.loadParameter.LoadParameterResponse
import com.example.kotlinStructure.data.model.loadParameter.LoadParametersRequest
import com.example.kotlinStructure.data.model.notification.NotificationSender
import com.example.kotlinStructure.data.model.notification.NotificationTypes
import com.example.kotlinStructure.data.model.sevice.ServiceProvider
import com.example.kotlinStructure.data.model.sevice.Services
import com.example.kotlinStructure.data.model.token.TokenRequest
import com.example.kotlinStructure.data.model.token.TokenResponse
import com.example.kotlinStructure.data.room.DBInterface
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class SettingRepository @Inject constructor(
    private val apiInterface: ApiInterface, private val dbInterface: DBInterface
) {

    fun getTokenData(request: TokenRequest): Observable<TokenResponse> {
        return apiInterface.getToken(request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getLoadParameters(request: LoadParametersRequest): Observable<LoadParameterResponse> {
        return apiInterface.getLoadParameters(request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    ////////////////////////local////////////////////////////

    fun insertLoadParameters(response: LoadParameterResponse): Completable {
        return dbInterface.insertTerminalSetting(response.terminalSetting!!)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .andThen(insertNotificationTypeList(response.notificationTypes))
            .andThen(insertNotificationSenderList(response.notificationSenders))
            .andThen(insertServiceProviderList(response.serviceProviders))
            .andThen(insertServicesList(response.services))
    }

    private fun insertNotificationTypeList(notificationTypes: List<NotificationTypes>?): Completable {
        return when {
            notificationTypes != null -> dbInterface.insertNotificationTypeList(notificationTypes)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
            else -> Completable.complete()
        }
    }

    private fun insertNotificationSenderList(notificationSenderList: List<NotificationSender>?): Completable {
        return when {
            notificationSenderList != null ->
                dbInterface.insertNotificationSenderList(notificationSenderList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
            else -> Completable.complete()
        }
    }

    private fun insertServiceProviderList(serviceProviderList: List<ServiceProvider>?): Completable {
        return when {
            serviceProviderList != null ->
                dbInterface.insertServiceProviderList(serviceProviderList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
            else -> Completable.complete()
        }
    }

    private fun insertServicesList(servicesList: List<Services>?): Completable {
        return when {
            servicesList != null ->
                dbInterface.insertServicesList(servicesList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
            else -> Completable.complete()
        }
    }
}
