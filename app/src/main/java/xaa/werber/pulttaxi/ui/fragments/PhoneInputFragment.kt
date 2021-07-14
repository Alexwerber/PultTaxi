package xaa.werber.pulttaxi.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_phone_input.*
import xaa.werber.pulttaxi.R
import xaa.werber.pulttaxi.utils.RequestStatus.SUCCESS
import xaa.werber.pulttaxi.viewmodel.MainViewModel
import xaa.werber.pulttaxi.viewmodel.ViewModelFactory
import javax.inject.Inject

class PhoneInputFragment : Fragment(R.layout.fragment_phone_input) {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

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