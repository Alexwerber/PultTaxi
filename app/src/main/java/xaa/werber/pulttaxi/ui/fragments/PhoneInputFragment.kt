package xaa.werber.pulttaxi.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_phone_input.*
import xaa.werber.pulttaxi.R
import xaa.werber.pulttaxi.ui.base.BaseFragment
import xaa.werber.pulttaxi.viewmodel.MainViewModel

class PhoneInputFragment: BaseFragment<MainViewModel>() {

    override fun getViewModel(): Class<MainViewModel> = MainViewModel::class.java

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
                viewModel.inputPhone(phone_input.text)
                activity?.let {  }
            }
            else phone_input.error = "Неверный формат номера"
        }
    }
}