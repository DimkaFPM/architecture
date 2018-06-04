package com.dimkafpm.architecture.data

import com.dimkafpm.architecture.data.network.NetworkDataStore
import javax.inject.Inject

class CountriesRepo @Inject constructor(private val networkDataStore: NetworkDataStore) {
}