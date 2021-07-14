package xaa.werber.pulttaxi.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_phone_input.*
import xaa.werber.pulttaxi.R
import xaa.werber.pulttaxi.ui.base.BaseFragment
import xaa.werber.pulttaxi.utils.RequestStatus.SUCCESS
import xaa.werber.pulttaxi.viewmodel.MainViewModel

class PhoneInputFragment: BaseFragment() {

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

        return inflater.inflate(R.layout.fragment_phone_input, container, false)
    }

    override fun onStart() {
        super.onStart()

        inputPhone()
    }

    private fun inputPhone() {
        confirm_button.setOnClickListener() {
            if (phone_input.text?.equals("") == false) {
                if (viewModel.getSMSCodeFromNetwork(phone_input.text.toString()) == SUCCESS) {
                    activity?.let {
                        it.supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.fragment_container, SMSInputFragment())
                            .commit()
                    }
                }
            }
            else phone_input.error = "Неверный формат номера"
        }
    }
}