package com.dimkafpm.architecture.data.network

import com.dimkafpm.architecture.data.network.api.CountryApi
import com.dimkafpm.architecture.data.network.model.CountryRemote
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

class NetworkDataStore @Inject constructor(retrofit: Retrofit) : CountryApi {

    private val countryApi = retrofit.create(CountryApi::class.java)

    override fun getAllCountries(): Observable<List<CountryRemote>> = countryApi.getAllCountries()
}