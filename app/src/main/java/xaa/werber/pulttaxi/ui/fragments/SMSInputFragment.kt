package xaa.werber.pulttaxi.ui.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_sms_code_input.*
import xaa.werber.pulttaxi.PultTaxiApp
import xaa.werber.pulttaxi.R
import xaa.werber.pulttaxi.data.entity.UserInfo
import xaa.werber.pulttaxi.error.CheckInput
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
import xaa.werber.pulttaxi.viewmodel.MainViewModel
import xaa.werber.pulttaxi.viewmodel.ViewModelFactory
import javax.inject.Inject

class SMSInputFragment: Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_sms_code_input, container, false)
    }

    override fun onStart() {
        super.onStart()

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.getUserInfo().observe(this, {
            if (it.phone_number != "") {
                showDialogInfo(it)
            }
        })

        inputSMS()
    }

    private fun inputSMS() {
        sms_confirm_button.setOnClickListener() {
            if (CheckInput.checkSMSCode(sms_input.value.toString())) {
                viewModel.getTokenFromNetwork(sms_input.value.toString())
            }
        }
    }

    private fun showDialogInfo(userInfo: UserInfo) {
        val myDialogFragment = DialogUserInfo()
        val manager = activity?.supportFragmentManager
        val bundle = bundleOf(
                STATUS to userInfo.status,
                PHONE_NUMBER to userInfo.phone_number,
                NAME to userInfo.name,
                EMAIL to userInfo.email,
                SEX to userInfo.sex,
                BIRTH_DAY to userInfo.birth_day,
                CITY to userInfo.city,
                RATING to userInfo.rating,
                ACTIVE_ORDER to userInfo.active_order,
                ORGANIZATION_ID to userInfo.organization_id
        )

        myDialogFragment.arguments = bundle

        if (manager != null) {
            myDialogFragment.show(manager, "myDialog")
        }
    }

}