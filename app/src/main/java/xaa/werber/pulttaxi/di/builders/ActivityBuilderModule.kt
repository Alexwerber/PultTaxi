package xaa.werber.pulttaxi.di.builders

import dagger.Module
import dagger.android.ContributesAndroidInjector
import xaa.werber.pulttaxi.ui.activities.MainActivity

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = arrayOf(FragmentBuilderModule::class))
    abstract fun mainActivity(): MainActivity
}