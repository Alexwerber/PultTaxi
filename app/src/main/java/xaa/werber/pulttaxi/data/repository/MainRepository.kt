package xaa.werber.pulttaxi.data.repository

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import xaa.werber.pulttaxi.data.entity.UserInfo
import xaa.werber.pulttaxi.data.local.dao.PultTaxiDao
import xaa.werber.pulttaxi.data.remote.ApiService

class MainRepository(private val apiService: ApiService, private val pultTaxiDao: PultTaxiDao) {

    fun SMSCodeRequest(number: String) {
        apiService.SMSCodeRequest(number).enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                // request is success
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                // print error
            }
        })
    }

    fun authorization(number: String, password: String) {
        apiService.authorization(number, password).enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                // save token to shared pref
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                // print error
            }
        })
    }

    fun getUserInfo(token: String) {
        apiService.getUserInfo(token).enqueue(object : Callback<UserInfo> {
            override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                // save user info
            }

            override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                // print error
            }
        })
    }

    fun getPhoneNumber()
}