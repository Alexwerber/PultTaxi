package xaa.werber.pulttaxi.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xaa.werber.pulttaxi.data.remote.ApiService
import xaa.werber.pulttaxi.utils.ApiConstants.BASE_URL
import xaa.werber.pulttaxi.utils.ApiConstants.READ_TIMEOUT
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class RetrofitModule {
    @Provides
    @Singleton
    fun provideOfHttpClient(): OkHttpClient = OkHttpClient.Builder().run {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        addInterceptor(interceptor)
        readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
        build()
    }

    @Provides
    @Singleton
    fun provideApiService(okHttpClient: OkHttpClient): ApiService =
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)
}