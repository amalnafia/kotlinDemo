package com.example.kotlinStructure.ui.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.kotlinStructure.data.model.Resource
import com.example.kotlinStructure.data.model.token.TokenRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject


@HiltViewModel
class SettingViewModel @Inject constructor(val settingRepo: SettingRepository) : ViewModel() {

    fun getToken(request: TokenRequest) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = settingRepo.getToken(request)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }


//    private var loadParameterMediatorLiveData: MutableLiveData<Resource<LoadParameterResponse>> =
//        MutableLiveData<Resource<LoadParameterResponse>>()
//
//    fun getLoadParameterResponse(request: LoadParametersRequest): MutableLiveData<Resource<LoadParameterResponse>> {
//        loadParameterMediatorLiveData.value = Resource(ApiStatus.LOADING, null, null)
//        if (networkHelper.isNetworkConnected()) {
//            settingRepo.getLoadParameters(request)
//                .subscribe(object : Observer<LoadParameterResponse?> {
//                    override fun onSubscribe(d: Disposable) {
//                    }
//
//                    override fun onNext(t: LoadParameterResponse) {
//                        loadParameterMediatorLiveData.value = Resource(ApiStatus.SUCCESS, t, null)
//                    }
//
//                    override fun onError(e: Throwable) {
//                        loadParameterMediatorLiveData.value =
//                            Resource(ApiStatus.ERROR, null, e.message)
//                    }
//
//                    override fun onComplete() {
//                    }
//
//                })
//        } else {
//            loadParameterMediatorLiveData.value =
//                Resource(ApiStatus.NOINTERNET, null, AppKeys.NoInternet.name)
//        }
//        return loadParameterMediatorLiveData
//    }
//
//    private val insertAllLoadParameters: MutableLiveData<RoomResource<Any>> = MediatorLiveData()
//
//    fun insertAllLoadParameters(loadParameterResponse: LoadParameterResponse): MutableLiveData<RoomResource<Any>> {
//        insertAllLoadParameters.value = RoomResource.loading()
//        settingRepo.insertLoadParameters(loadParameterResponse)
//            .subscribe(object : CompletableObserver {
//                override fun onSubscribe(d: Disposable) {}
//                override fun onComplete() {
//                    insertAllLoadParameters.value = RoomResource.success(null)
//                }
//
//                override fun onError(e: Throwable) {
//                    insertAllLoadParameters.value = RoomResource.error("Error " + e.message)
//                    Log.e("", "onError: ", e)
//                }
//            })
//        return insertAllLoadParameters
//    }
}