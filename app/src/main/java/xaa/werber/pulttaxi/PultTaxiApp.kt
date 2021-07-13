package xaa.werber.pulttaxi

import android.app.Application
import xaa.werber.pulttaxi.di.components.DaggerAppComponents

class PultTaxiApp: Application() {

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponents.builder().application(this).build().inject(this)
    }
}