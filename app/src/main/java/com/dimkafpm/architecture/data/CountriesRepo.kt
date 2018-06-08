package com.dimkafpm.architecture.data

import com.dimkafpm.architecture.data.db.DbDataSource
import com.dimkafpm.architecture.data.network.NetworkDataStore
import com.dimkafpm.architecture.data.network.model.toDomain
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CountriesRepo @Inject constructor(private val networkDataStore: NetworkDataStore,
                                        private val dbDataSource: DbDataSource) {

    fun getCountries() = networkDataStore.getAllCountries()
            .map { list -> list.map { it.toDomain() } }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}