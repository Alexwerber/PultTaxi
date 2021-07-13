package xaa.werber.pulttaxi.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component

@Component(modules = [

])
interface AppComponents {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponents
    }

    fun inject()
}