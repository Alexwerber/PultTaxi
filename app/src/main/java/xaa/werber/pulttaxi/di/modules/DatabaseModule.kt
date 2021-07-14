package xaa.werber.pulttaxi.di.modules

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import xaa.werber.pulttaxi.data.local.PultTaxiDatabase
import xaa.werber.pulttaxi.data.local.dao.PultTaxiDao
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun providePutlTaxiDatabase(application: Application): PultTaxiDatabase =
        Room.databaseBuilder(application, PultTaxiDatabase::class.java, "putlTaxi.db").build()

    @Provides
    @Singleton
    fun providePultTaxiDao(pultTaxiDatabase: PultTaxiDatabase): PultTaxiDao =
        pultTaxiDatabase.getPultTaxiDao()
}