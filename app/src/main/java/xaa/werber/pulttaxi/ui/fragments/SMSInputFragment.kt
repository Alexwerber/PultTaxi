package xaa.werber.pulttaxi.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_sms_code_input.*
import xaa.werber.pulttaxi.R
import xaa.werber.pulttaxi.ui.base.BaseFragment
import xaa.werber.pulttaxi.viewmodel.MainViewModel

class SMSInputFragment: BaseFragment() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
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

        inputSMS()
    }

    private fun inputSMS() {
        sms_confirm_button.setOnClickListener() {
            if (sms_input.text?.equals("") == true) {
                viewModel.getTokenFromNetwork(sms_input.text.toString())
                // show dialog
            }
            else sms_input.error = "Введите код"
        }
    }

}