package xaa.werber.pulttaxi.ui.fragments

import xaa.werber.pulttaxi.ui.base.BaseFragment
import xaa.werber.pulttaxi.viewmodel.MainViewModel

class PhoneInputFragment: BaseFragment<MainViewModel>() {

    override fun getViewModel(): Class<MainViewModel> = MainViewModel::class.java

}