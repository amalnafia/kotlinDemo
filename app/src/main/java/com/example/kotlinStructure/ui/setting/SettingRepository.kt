package com.example.kotlinStructure.ui.setting

import com.example.kotlinStructure.data.api.ApiInterface
import com.example.kotlinStructure.data.model.loadParameter.LoadParametersRequest
import com.example.kotlinStructure.data.model.sevice.ServiceProvider
import com.example.kotlinStructure.data.model.sevice.Services
import com.example.kotlinStructure.data.model.terminalSetting.TerminalSetting
import com.example.kotlinStructure.data.model.token.TokenRequest
import com.example.kotlinStructure.data.model.users.UsersManagement
import com.example.kotlinStructure.data.room.DBInterface
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingRepository @Inject constructor(
    private val apiInterface: ApiInterface, private val dbInterface: DBInterface
) {

    suspend fun getToken(request: TokenRequest) = apiInterface.getToken(request)

    suspend fun getLoadParameters(request: LoadParametersRequest) =
        apiInterface.getLoadParameters(request)

    suspend fun insetUser(userManagement: UsersManagement) =
        dbInterface.insertUsersManagement(userManagement)

    suspend fun insertTerminalSetting(terminalSetting: TerminalSetting) =
        dbInterface.insertTerminalSetting(terminalSetting)

    suspend fun insertServiceProvider(serviceProvider: List<ServiceProvider>) =
        dbInterface.insertServiceProviderList(serviceProvider)

    suspend fun insertServices(services: List<Services>) =
        dbInterface.insertServicesList(services)
}