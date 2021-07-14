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
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_sms_code_input.*
import xaa.werber.pulttaxi.PultTaxiApp
import xaa.werber.pulttaxi.R
import xaa.werber.pulttaxi.error.CheckInput
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
                //show dialog
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

}