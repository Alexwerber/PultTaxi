package xaa.werber.pulttaxi.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment<V: ViewModel>: Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: ViewModel

    abstract fun getViewModel(): Class<V>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }
}