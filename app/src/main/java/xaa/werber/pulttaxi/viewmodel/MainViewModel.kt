package xaa.werber.pulttaxi.viewmodel

import androidx.lifecycle.ViewModel
import xaa.werber.pulttaxi.data.repository.MainRepository

class MainViewModel(private val repository: MainRepository): ViewModel() {

    fun getPhoneNumber(): String = repository.getPhoneNumber()

    fun getSMSCodeFromNetwork(number: String) {
        repository.SMSCodeRequest(number)
    }

    fun getTokenFromNetwork(number: String, password: String) {
        repository.authorization(number, password)
    }

    fun getUserInfoFromNetwork(token: String) {
        repository.getUserInfo(token)
    }
}