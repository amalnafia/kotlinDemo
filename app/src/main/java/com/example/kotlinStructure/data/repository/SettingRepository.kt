package com.example.kotlinStructure.data.repository


import androidx.lifecycle.MutableLiveData
import com.example.kotlinStructure.data.api.ApiInterface
import com.example.kotlinStructure.data.model.loadParameter.LoadParameterResponse
import com.example.kotlinStructure.data.model.loadParameter.LoadParametersRequest
import com.example.kotlinStructure.data.model.token.TokenRequest
import com.example.kotlinStructure.data.model.token.TokenResponse
import com.example.kotlinStructure.enums.ApiStatus
import com.example.kotlinStructure.util.Resource
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class SettingRepository @Inject constructor(private val apiInterface: ApiInterface) {

//    private val tokenDataMediatorLiveData: MutableLiveData<Resource<TokenResponse>> =
//        MutableLiveData<Resource<TokenResponse>>()
    private val loadParameterMediatorLiveData: MutableLiveData<Resource<LoadParameterResponse>> =
        MutableLiveData<Resource<LoadParameterResponse>>()

    //    fun getTokenData(request: TokenRequest): MutableLiveData<Resource<TokenResponse>> {
//        tokenDataMediatorLiveData.value = Resource(ApiStatus.LOADING, null, null)
//        apiInterface.getToken(request)
//            ?.subscribeOn(Schedulers.io())
//            ?.observeOn(AndroidSchedulers.mainThread())
//            ?.subscribe(object : Observer<TokenResponse?> {
//                override fun onSubscribe(d: Disposable) {
//                }
//
//                override fun onNext(t: TokenResponse) {
//                    tokenDataMediatorLiveData.value = Resource(ApiStatus.SUCCESS, t, null)
//                }
//
//                override fun onError(e: Throwable) {
//                    tokenDataMediatorLiveData.value =
//                        Resource(ApiStatus.ERROR, null, e.message)
//                }
//
//                override fun onComplete() {
//                }
//
//            })
//        return tokenDataMediatorLiveData
//    }
    fun getTokenData(request: TokenRequest): Observable<TokenResponse> {
        return apiInterface.getToken(request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getLoadParameters(request: LoadParametersRequest): MutableLiveData<Resource<LoadParameterResponse>> {
        loadParameterMediatorLiveData.value = Resource(ApiStatus.LOADING, null, null)
        apiInterface.getLoadParameters(request)
            .subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : Observer<LoadParameterResponse?> {
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
        return loadParameterMediatorLiveData
    }
}
