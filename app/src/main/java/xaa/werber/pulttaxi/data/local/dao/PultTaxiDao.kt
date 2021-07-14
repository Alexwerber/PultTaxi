package xaa.werber.pulttaxi.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import xaa.werber.pulttaxi.data.entity.UserInfo

@Dao
interface PultTaxiDao {
    @Query("SELECT * FROM userInfo")
    fun getUserInfo(): LiveData<UserInfo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun safeUserInfo(userInfo: UserInfo)
}