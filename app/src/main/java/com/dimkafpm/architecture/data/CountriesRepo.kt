package com.dimkafpm.architecture.data

import com.dimkafpm.architecture.data.db.DbDataSource
import com.dimkafpm.architecture.data.db.model.fromDomain
import com.dimkafpm.architecture.data.db.model.toDomain
import com.dimkafpm.architecture.data.network.NetworkDataStore
import com.dimkafpm.architecture.data.network.model.toDomain
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CountriesRepo @Inject constructor(private val networkDataStore: NetworkDataStore,
                                        private val dbDataSource: DbDataSource) {

    fun getCountries() = Observable.concat(getCountriesFromDb(), getCountriesFromNetwork())
            .filter { !it.isEmpty() }
            .firstElement()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    private fun getCountriesFromDb() = Observable.fromCallable { dbDataSource.countryDao().getAll().map { it.toDomain() } }

    private fun getCountriesFromNetwork() = networkDataStore.getAllCountries()
            .map { list -> list.map { it.toDomain() } }
            .doOnNext {
                val dao = dbDataSource.countryDao()
                dao.clearCountries()
                dao.insert(it.map { fromDomain(it) })
            }
}