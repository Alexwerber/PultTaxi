package xaa.werber.pulttaxi.di.modules

import dagger.Module
import dagger.Provides
import xaa.werber.pulttaxi.data.remote.ApiService
import xaa.werber.pulttaxi.data.repository.MainRepository
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideMainRepository(apiService: ApiService): MainRepository = MainRepository(apiService)
}