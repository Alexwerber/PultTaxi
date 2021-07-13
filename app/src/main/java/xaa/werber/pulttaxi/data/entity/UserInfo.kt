package xaa.werber.pulttaxi.data.entity

data class UserInfo(
    var status: Int? = null,
    var id: Int? = null,
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
