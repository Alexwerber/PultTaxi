package xaa.werber.pulttaxi.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import xaa.werber.pulttaxi.data.entity.UserInfo

interface ApiService {
    // Запрос смс кода
    @GET("/requestSMSCodeClient")
    fun SMSCodeRequest(
        @Query("phone_number") number: String
    ) : Call<String>

    // Авторизация через СМС код
    @GET("/authenticateClients")
    fun authorization(
        @Query("phone_number") number: String,
        @Query("password") password: String
    ) : Call<String>

    // Получение информации о клиенте
    @GET("/client/getInfo")
    fun getUserInfo(
        @Query("token") token: String
    ) : Call<UserInfo>
}