package xaa.werber.pulttaxi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import xaa.werber.pulttaxi.data.entity.UserInfo
import xaa.werber.pulttaxi.data.repository.MainRepository
import xaa.werber.pulttaxi.utils.PhoneMask

class MainViewModel(private val repository: MainRepository): ViewModel() {

    fun getUserInfo(): LiveData<UserInfo> = repository.getUseInfo()
    fun getToken(): String? = repository.getToken()

    init {
        loadData()
    }

    fun loadData() {
        repository.loadData()
    }

    fun getSMSCodeFromNetwork(number: String) {
        repository.smsCodeRequest(number)
    }

    fun getTokenFromNetwork(password: String) {
        repository.authorization(password)
    }

    fun getUserInfoFromNetwork(token: String) {
        repository.getUserInfoFromNetwork(token)
    }
}