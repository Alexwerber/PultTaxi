package xaa.werber.pulttaxi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userInfo")
data class UserInfo(
    @PrimaryKey
    var id: Int = 1,

    var status: Int? = null,
    var phone_number: String? = null,
    var name: String? = null,
    var email: String? = null,
    var sex: String? = null,
    var birth_day: String? = null,
    var city: String? = null,
    var rating: String? = null,
    var active_order: Int? = null,
    var organization_id: Int? = null,
    var need_registration: Boolean
)
