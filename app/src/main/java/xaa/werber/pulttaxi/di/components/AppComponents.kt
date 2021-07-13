package xaa.werber.pulttaxi.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import xaa.werber.pulttaxi.PultTaxiApp
import xaa.werber.pulttaxi.di.modules.RetrofitModule

@Component(modules = [
    RetrofitModule::class
])
interface AppComponents {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponents
    }

    fun inject(app: PultTaxiApp)
}