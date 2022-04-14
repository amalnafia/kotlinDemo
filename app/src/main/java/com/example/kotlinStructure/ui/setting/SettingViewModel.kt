package com.example.kotlinStructure.ui.setting

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlinStructure.data.model.loadParameter.LoadParametersRequest
import com.example.kotlinStructure.data.model.loadParameter.LoadParametersResponse
import com.example.kotlinStructure.data.model.token.TokenRequest
import com.example.kotlinStructure.data.model.token.TokenResponse
import com.example.kotlinStructure.data.model.users.UsersManagement
import com.example.kotlinStructure.enums.SharedPrefKeys
import com.example.kotlinStructure.util.LocalStatus
import com.example.kotlinStructure.util.Resource
import com.example.kotlinStructure.util.SharedPrefHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SettingViewModel @Inject constructor(
    private val settingRepo: SettingRepository,
    private val reference: SharedPrefHelper
) :
    ViewModel() {

    val tokenLiveData: MutableLiveData<Resource<TokenResponse>> = MutableLiveData()
    fun setTokenRequest(request: TokenRequest) {
        tokenLiveData.postValue(Resource.Loading())
        viewModelScope.launch {
            try {
                val response = settingRepo.getToken(request)
                if (response.responseHeader?.statusCode == 200)
                    tokenLiveData.postValue(Resource.Success(response))
                else
                    tokenLiveData.postValue(Resource.Error(response.responseHeader?.message!!))
            } catch (ex: Exception) {
                tokenLiveData.postValue(Resource.Error("Network Failure " + ex.localizedMessage))
            }
        }
    }

    val loadParametersLiveData: MutableLiveData<Resource<LoadParametersResponse>> =
        MutableLiveData()

    fun setLoadParametersRequest(request: LoadParametersRequest) {
        loadParametersLiveData.postValue(Resource.Loading())
        viewModelScope.launch {
            try {
                val response = settingRepo.getLoadParameters(request)
                if (response.responseHeader?.statusCode == 200)
                    loadParametersLiveData.postValue(Resource.Success(response))
                else
                    loadParametersLiveData.postValue(Resource.Error(response.responseHeader?.message!!))
            } catch (ex: Exception) {
                loadParametersLiveData.postValue(Resource.Error("Network Failure " + ex.localizedMessage))
            }
        }
    }

    private var loadParametersData: LoadParametersResponse? = null
    fun getLoadParametersData(): LoadParametersResponse? {
        return loadParametersData
    }

    fun setLoadParametersData(loadParametersData: LoadParametersResponse?) {
        this.loadParametersData = loadParametersData
    }

    val insertUserLiveData: MutableLiveData<LocalStatus> = MutableLiveData()

    fun insertUser() {
        viewModelScope.launch {
            try {
                settingRepo.insetUser(
                    UsersManagement(
                        1, "admin",
                        reference.getStringFromShared(SharedPrefKeys.password.name),
                        loadParametersData?.terminalSetting!!.enableOffline,
                        loadParametersData?.terminalSetting!!.enableOnline,
                        loadParametersData?.terminalSetting!!.enableTopUp,
                        loadParametersData?.terminalSetting!!.enableBillPayment,
                        1, "dateTime", "", true, true, false,
                        loadParametersData?.terminalSetting!!.enableResetLimit, 1, 1
                    )
                )
                insertUserLiveData.postValue(LocalStatus.Success())
            } catch (ex: Exception) {
                insertUserLiveData.postValue(LocalStatus.Error(ex.localizedMessage.toString()))
            }
        }
    }

    val insertTerminalSettingLiveData: MutableLiveData<LocalStatus> = MutableLiveData()

    fun insertTerminalSetting() {
        viewModelScope.launch {
            try {
                settingRepo.insertTerminalSetting(loadParametersData?.terminalSetting!!)
                insertTerminalSettingLiveData.postValue(LocalStatus.Success())
            } catch (ex: Exception) {
                insertTerminalSettingLiveData.postValue(LocalStatus.Error(ex.localizedMessage.toString()))
            }
        }
    }

    val insertServiceProviderLiveData: MutableLiveData<LocalStatus> = MutableLiveData()

    fun insertServiceProvider() {
        viewModelScope.launch(Dispatchers.Default) {
            try {
                settingRepo.insertServiceProvider(loadParametersData?.serviceProviders!!)
                insertServiceProviderLiveData.postValue(LocalStatus.Success())
            } catch (ex: Exception) {
                insertServiceProviderLiveData.postValue(LocalStatus.Error(ex.localizedMessage.toString()))
            }
        }
    }

    val insertServicesLiveData: MutableLiveData<LocalStatus> = MutableLiveData()

    fun insertServices() {
        viewModelScope.launch {
            try {
                settingRepo.insertServices(loadParametersData?.services!!)
                insertServicesLiveData.postValue(LocalStatus.Success())
            } catch (ex: Exception) {
                insertServicesLiveData.postValue(LocalStatus.Error(ex.localizedMessage.toString()))
            }
        }
    }
}