package xaa.werber.pulttaxi.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import xaa.werber.pulttaxi.PultTaxiApp
import xaa.werber.pulttaxi.di.builders.ActivityBuilderModule
import xaa.werber.pulttaxi.di.modules.RepositoryModule
import xaa.werber.pulttaxi.di.modules.RetrofitModule
import xaa.werber.pulttaxi.di.modules.ViewModelModule
import javax.inject.Singleton

@Component(modules = [
    AndroidInjectionModule::class,
    ActivityBuilderModule::class,
    RepositoryModule::class,
    ViewModelModule::class,
    RetrofitModule::class
])
@Singleton
interface AppComponents {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponents
    }

    fun inject(app: PultTaxiApp)
}