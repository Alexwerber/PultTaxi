package xaa.werber.pulttaxi.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import xaa.werber.pulttaxi.data.local.dao.PultTaxiDao
import xaa.werber.pulttaxi.data.remote.ApiService
import xaa.werber.pulttaxi.data.repository.MainRepository
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideMainRepository(apiService: ApiService, pultTaxiDao: PultTaxiDao, context: Context): MainRepository =
        MainRepository(apiService, pultTaxiDao, context)
}