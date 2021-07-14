package xaa.werber.pulttaxi.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_sms_code_input.*
import xaa.werber.pulttaxi.R
import xaa.werber.pulttaxi.ui.base.BaseFragment
import xaa.werber.pulttaxi.viewmodel.MainViewModel

class SMSInputFragment: BaseFragment<MainViewModel>() {

    override fun getViewModel(): Class<MainViewModel> = MainViewModel::class.java

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sms_code_input, container, false)
    }

    override fun onStart() {
        super.onStart()

        inputSMS()
    }

    private fun inputSMS() {
        sms_confirm_button.setOnClickListener() {
            if (sms_input.text?.equals("") == true) {
                viewModel.inputSMS(sms_input.text)
                // show dialog
            }
            else sms_input.error = "Введите код"
        }
    }

}