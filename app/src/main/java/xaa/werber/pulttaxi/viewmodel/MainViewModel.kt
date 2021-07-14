package xaa.werber.pulttaxi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import xaa.werber.pulttaxi.data.entity.UserInfo
import xaa.werber.pulttaxi.data.repository.MainRepository
import xaa.werber.pulttaxi.utils.RequestStatus.ERROR
import xaa.werber.pulttaxi.utils.RequestStatus.SUCCESS

class MainViewModel(private val repository: MainRepository): ViewModel() {

    private lateinit var phoneNumber: String

    fun getUserInfo(): LiveData<UserInfo> = repository.getUseInfo()
    fun getToken(): String? = repository.getToken()

    fun getSMSCodeFromNetwork(number: String): String {
        val status = repository.smsCodeRequest(number)

        if (status == SUCCESS) {
            phoneNumber = number
            return status
        } else
            return ERROR
    }

    fun getTokenFromNetwork(password: String) {
        repository.authorization(phoneNumber, password)
    }

    fun getUserInfoFromNetwork(token: String) {
        repository.getUserInfoFromNetwork(token)
    }
}