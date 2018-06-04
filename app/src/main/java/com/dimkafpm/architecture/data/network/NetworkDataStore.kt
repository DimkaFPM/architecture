package com.dimkafpm.architecture.data.network

import com.dimkafpm.architecture.data.network.api.CountryApi
import com.dimkafpm.architecture.data.network.model.Country
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

class NetworkDataStore @Inject constructor(private val retrofit: Retrofit) : CountryApi {

    private val countryApi = retrofit.create(CountryApi::class.java)

    override fun getAllCountries(): Observable<List<Country>> = countryApi.getAllCountries()
}