package com.example.kotlinStructure.ui.setting

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinStructure.data.model.loadParameter.LoadParameterResponse
import com.example.kotlinStructure.data.model.loadParameter.LoadParametersRequest
import com.example.kotlinStructure.data.model.terminalSetting.TerminalSetting
import com.example.kotlinStructure.data.model.token.TokenRequest
import com.example.kotlinStructure.data.model.token.TokenResponse
import com.example.kotlinStructure.data.repository.DBRepository
import com.example.kotlinStructure.data.repository.SettingRepository
import com.example.kotlinStructure.enums.ApiStatus
import com.example.kotlinStructure.module.NetworkHelper
import com.example.kotlinStructure.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val settingRepo: SettingRepository,
    private val dbRepo: DBRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {
    private var tokenDataMediatorLiveData: MutableLiveData<Resource<TokenResponse>> =
        MutableLiveData<Resource<TokenResponse>>()

    fun getTokenData(request: TokenRequest): MutableLiveData<Resource<TokenResponse>> {

        tokenDataMediatorLiveData.value = Resource(ApiStatus.LOADING, null, null)

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
        return tokenDataMediatorLiveData
    }

    private var loadParameterMediatorLiveData: MutableLiveData<Resource<LoadParameterResponse>> =
        MutableLiveData<Resource<LoadParameterResponse>>()

    fun setLoadParameterRequest(request: LoadParametersRequest) {
        loadParameterMediatorLiveData = settingRepo.getLoadParameters(request)
    }

    fun getLoadParameterResponse(): MutableLiveData<Resource<LoadParameterResponse>> {
        return loadParameterMediatorLiveData
    }

    fun insertTerminalSetting(terminalSetting: TerminalSetting?): MediatorLiveData<Resource<Any>> {
        return dbRepo.insertTerminalSetting(terminalSetting)
    }

}