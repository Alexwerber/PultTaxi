package xaa.werber.pulttaxi.ui.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import xaa.werber.pulttaxi.R
import xaa.werber.pulttaxi.data.entity.UserInfo
import xaa.werber.pulttaxi.ui.fragments.DialogUserInfo
import xaa.werber.pulttaxi.ui.fragments.PhoneInputFragment
import xaa.werber.pulttaxi.utils.BundleKeys
import xaa.werber.pulttaxi.viewmodel.MainViewModel
import xaa.werber.pulttaxi.viewmodel.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}