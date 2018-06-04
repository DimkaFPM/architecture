package com.dimkafpm.architecture.di

import android.content.Context
import android.preference.PreferenceManager
import com.dimkafpm.architecture.App
import com.dimkafpm.architecture.BuildConfig
import com.dimkafpm.architecture.data.CountriesRepo
import com.dimkafpm.architecture.data.network.NetworkDataStore
import com.dimkafpm.architecture.data.network.RestClientBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return app
    }

    @Provides
    @Singleton
    internal fun provideRetrofit() = RestClientBuilder(BuildConfig.HOST).build()

    @Provides
    @Singleton
    internal fun providePreferences(context: Context) = PreferenceManager.getDefaultSharedPreferences(context)

    @Provides
    @Singleton
    internal fun provideNetworkDataStore(retrofit: Retrofit) = NetworkDataStore(retrofit)

    @Provides
    @Singleton
    internal fun provideCountriesRepo(networkDataStore: NetworkDataStore) = CountriesRepo(networkDataStore)
}
