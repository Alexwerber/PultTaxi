package xaa.werber.pulttaxi.di.builders

import dagger.Module
import dagger.android.ContributesAndroidInjector
import xaa.werber.pulttaxi.ui.fragments.PhoneInputFragment
import xaa.werber.pulttaxi.ui.fragments.SMSInputFragment

@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributePhoneInputFragment(): PhoneInputFragment

    @ContributesAndroidInjector
    abstract fun contributeSmsInputFragment(): SMSInputFragment
}