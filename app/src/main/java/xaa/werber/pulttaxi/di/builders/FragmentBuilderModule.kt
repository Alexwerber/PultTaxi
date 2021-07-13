package xaa.werber.pulttaxi.di.builders

import dagger.Module
import dagger.android.ContributesAndroidInjector
import xaa.werber.pulttaxi.ui.fragments.PhoneInputFragment

@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributesPhoneInputFragment(): PhoneInputFragment
}