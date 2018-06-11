package com.dimkafpm.architecture.di

import android.arch.persistence.room.Room
import android.content.Context
import android.preference.PreferenceManager
import com.dimkafpm.architecture.App
import com.dimkafpm.architecture.BuildConfig
import com.dimkafpm.architecture.data.CountriesRepo
import com.dimkafpm.architecture.data.db.DbContract
import com.dimkafpm.architecture.data.db.DbDataSource
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
    internal fun provideDbDataSource(): DbDataSource {
        val databaseName = "countries_database"
        return Room.databaseBuilder(app, DbDataSource::class.java, databaseName)
                .addMigrations(DbContract.MIGRATION_1_2)
                .build()
    }

    @Provides
    @Singleton
    internal fun provideCountriesRepo(networkDataStore: NetworkDataStore, dbDataSource: DbDataSource) = CountriesRepo(networkDataStore, dbDataSource)
}
