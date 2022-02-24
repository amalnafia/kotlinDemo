package com.example.kotlinStructure.ui.setting

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinStructure.data.model.loadParameter.LoadParameterResponse
import com.example.kotlinStructure.data.model.loadParameter.LoadParametersRequest
import com.example.kotlinStructure.data.model.token.TokenRequest
import com.example.kotlinStructure.data.model.token.TokenResponse
import com.example.kotlinStructure.data.repository.SettingRepository
import com.example.kotlinStructure.enums.ApiStatus
import com.example.kotlinStructure.enums.AppKeys
import com.example.kotlinStructure.module.NetworkHelper
import com.example.kotlinStructure.util.Resource
import com.example.kotlinStructure.util.RoomResource
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.CompletableObserver
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val settingRepo: SettingRepository,
    private val networkHelper: NetworkHelper,
) : ViewModel() {

    private var tokenDataMediatorLiveData: MutableLiveData<Resource<TokenResponse>> =
        MutableLiveData<Resource<TokenResponse>>()

    fun getTokenData(request: TokenRequest): MutableLiveData<Resource<TokenResponse>> {
        tokenDataMediatorLiveData.value = Resource(ApiStatus.LOADING, null, null)
        if (networkHelper.isNetworkConnected()) {
            settingRepo.getTokenData(request).subscribe(object : Observer<TokenResponse?> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: TokenResponse) {
                    tokenDataMediatorLiveData.value = Resource(ApiStatus.SUCCESS, t, null)
                }

                override fun onError(e: Throwable) {
                    tokenDataMediatorLiveData.value = Resource(ApiStatus.ERROR, null, e.message)
                }

                override fun onComplete() {
                }
            })
        } else {
            tokenDataMediatorLiveData.value =
                Resource(ApiStatus.NOINTERNET, null, AppKeys.NoInternet.name)
        }
        return tokenDataMediatorLiveData
    }

    private var loadParameterMediatorLiveData: MutableLiveData<Resource<LoadParameterResponse>> =
        MutableLiveData<Resource<LoadParameterResponse>>()

    fun getLoadParameterResponse(request: LoadParametersRequest): MutableLiveData<Resource<LoadParameterResponse>> {
        loadParameterMediatorLiveData.value = Resource(ApiStatus.LOADING, null, null)
        if (networkHelper.isNetworkConnected()) {
            settingRepo.getLoadParameters(request)
                .subscribe(object : Observer<LoadParameterResponse?> {
                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(t: LoadParameterResponse) {
                        loadParameterMediatorLiveData.value = Resource(ApiStatus.SUCCESS, t, null)
                    }

                    override fun onError(e: Throwable) {
                        loadParameterMediatorLiveData.value =
                            Resource(ApiStatus.ERROR, null, e.message)
                    }

                    override fun onComplete() {
                    }

                })
        } else {
            loadParameterMediatorLiveData.value =
                Resource(ApiStatus.NOINTERNET, null, AppKeys.NoInternet.name)
        }
        return loadParameterMediatorLiveData
    }

    private val insertAllLoadParameters: MutableLiveData<RoomResource<Any>> = MediatorLiveData()

    fun insertAllLoadParameters(loadParameterResponse: LoadParameterResponse): MutableLiveData<RoomResource<Any>> {
        insertAllLoadParameters.value = RoomResource.loading()
        settingRepo.insertLoadParameters(loadParameterResponse)
            .subscribe(object : CompletableObserver {
                override fun onSubscribe(d: Disposable) {}
                override fun onComplete() {
                    insertAllLoadParameters.value = RoomResource.success(null)
                }

                override fun onError(e: Throwable) {
                    insertAllLoadParameters.value = RoomResource.error("Error " + e.message)
                    Log.e("", "onError: ", e)
                }
            })
        return insertAllLoadParameters
    }
}