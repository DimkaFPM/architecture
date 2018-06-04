package com.dimkafpm.architecture

import android.app.Application
import com.dimkafpm.architecture.di.AppComponent
import com.dimkafpm.architecture.di.AppModule
import com.dimkafpm.architecture.di.DaggerAppComponent

class App : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    fun getAppComponent(): AppComponent = appComponent

}