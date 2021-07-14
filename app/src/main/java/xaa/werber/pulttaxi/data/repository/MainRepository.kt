package xaa.werber.pulttaxi.data.repository

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import xaa.werber.pulttaxi.data.entity.UserInfo
import xaa.werber.pulttaxi.data.local.dao.PultTaxiDao
import xaa.werber.pulttaxi.data.remote.ApiService
import java.util.concurrent.Executors

class MainRepository(val apiService: ApiService, val pultTaxiDao: PultTaxiDao) {

    private lateinit var sharedPreferences: SharedPreferences

    init {
        //init sherPref
    }

    fun getToken(): String? = sharedPreferences.getString("TOKEN", null)
    fun getUseInfo(): LiveData<UserInfo> = pultTaxiDao.getUserInfo()

    fun SMSCodeRequest(number: String): String = apiService.SMSCodeRequest(number)

    fun authorization(number: String, password: String) {
        apiService.authorization(number, password).enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        sharedPreferences.edit().putString("TOKEN", response.body())
                        getUserInfoFromNetwork(response.body()!!)
                    }
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                // print error somewhere
            }
        })
    }

    fun getUserInfoFromNetwork(token: String) {
        apiService.getUserInfo(token).enqueue(object : Callback<UserInfo> {
            override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                if (response.isSuccessful) {
                    response.body()?.let { saveUserInfo(it) }
                }
            }

            override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                // print error somewhere
            }
        })
    }

    fun saveUserInfo(userInfo: UserInfo) {
        Executors.newSingleThreadExecutor().execute(
            fun () {pultTaxiDao.safeUserInfo(userInfo)}
        )
    }
}