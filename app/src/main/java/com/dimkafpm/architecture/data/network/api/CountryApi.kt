package com.dimkafpm.architecture.data.network.api

import com.dimkafpm.architecture.data.network.model.CountryRemote
import io.reactivex.Observable
import retrofit2.http.GET

interface CountryApi {

    @GET("rest/v1/all")
    fun getAllCountries() : Observable<List<CountryRemote>>

}