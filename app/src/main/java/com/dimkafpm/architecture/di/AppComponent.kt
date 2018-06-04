package com.dimkafpm.architecture.di

import android.content.Context
import android.content.SharedPreferences
import com.dimkafpm.architecture.data.CountriesRepo
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {

    fun context(): Context
    fun retrofit(): Retrofit
    fun preferences(): SharedPreferences
    fun countriesRepo(): CountriesRepo
}
