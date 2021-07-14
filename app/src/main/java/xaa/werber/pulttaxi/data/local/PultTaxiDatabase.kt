package xaa.werber.pulttaxi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import xaa.werber.pulttaxi.data.entity.UserInfo
import xaa.werber.pulttaxi.data.local.dao.PultTaxiDao

@Database(entities = [UserInfo::class], version = 1, exportSchema = false)
abstract class PultTaxiDatabase: RoomDatabase() {
    abstract fun getPultTaxiDao(): PultTaxiDao
}