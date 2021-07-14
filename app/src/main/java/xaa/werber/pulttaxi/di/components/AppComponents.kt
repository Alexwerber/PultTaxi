package xaa.werber.pulttaxi.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import xaa.werber.pulttaxi.PultTaxiApp
import xaa.werber.pulttaxi.di.builders.ActivityBuilderModule
import xaa.werber.pulttaxi.di.modules.*
import xaa.werber.pulttaxi.ui.fragments.PhoneInputFragment
import xaa.werber.pulttaxi.ui.fragments.SMSInputFragment
import javax.inject.Singleton

@Component(modules = [
    RepositoryModule::class,
    AndroidInjectionModule::class,
    ActivityBuilderModule::class,
    ViewModelModule::class,
    RetrofitModule::class,
    DatabaseModule::class,
    AppModule::class
])
@Singleton
interface AppComponents {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponents
    }

    fun inject(pultTaxiApp: PultTaxiApp)
}