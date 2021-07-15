package xaa.werber.pulttaxi.ui.fragments

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.dialog_user_info.*
import xaa.werber.pulttaxi.R
import xaa.werber.pulttaxi.utils.BundleKeys.ACTIVE_ORDER
import xaa.werber.pulttaxi.utils.BundleKeys.BIRTH_DAY
import xaa.werber.pulttaxi.utils.BundleKeys.CITY
import xaa.werber.pulttaxi.utils.BundleKeys.EMAIL
import xaa.werber.pulttaxi.utils.BundleKeys.NAME
import xaa.werber.pulttaxi.utils.BundleKeys.ORGANIZATION_ID
import xaa.werber.pulttaxi.utils.BundleKeys.PHONE_NUMBER
import xaa.werber.pulttaxi.utils.BundleKeys.RATING
import xaa.werber.pulttaxi.utils.BundleKeys.SEX
import xaa.werber.pulttaxi.utils.BundleKeys.STATUS

class DialogUserInfo: DialogFragment(R.layout.dialog_user_info) {
    override fun onStart() {
        super.onStart()
        arguments?.let {
            it.getInt(STATUS)?.let { status_info.text = it.toString() }
            it.getInt(PHONE_NUMBER)?.let { phone_number_info.text = it.toString() }
            it.getInt(NAME)?.let { name_info.text = it.toString() }
            it.getInt(EMAIL)?.let { email_info.text = it.toString() }
            it.getInt(SEX)?.let { sex_info.text = it.toString() }
            it.getInt(BIRTH_DAY)?.let { birthday_info.text = it.toString() }
            it.getInt(CITY)?.let { city_info.text = it.toString() }
            it.getInt(RATING)?.let { rating_info.text = it.toString() }
            it.getInt(ACTIVE_ORDER)?.let { active_order_info.text = it.toString() }
        }
    }
}