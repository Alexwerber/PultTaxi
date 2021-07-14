package xaa.werber.pulttaxi.viewmodel

import androidx.lifecycle.ViewModel
import xaa.werber.pulttaxi.data.repository.MainRepository

class MainViewModel(private val repository: MainRepository): ViewModel() {

    private var phoneNumber: String? = null

    fun getPhoneNumber(): String? = phoneNumber

    fun getSMSCodeFromNetwork(number: String) {
        phoneNumber = number
        repository.SMSCodeRequest(number)
    }

    fun getTokenFromNetwork(number: String, password: String) {
        repository.authorization(number, password)
    }

    fun getUserInfoFromNetwork(token: String) {
        repository.getUserInfo(token)
    }
}