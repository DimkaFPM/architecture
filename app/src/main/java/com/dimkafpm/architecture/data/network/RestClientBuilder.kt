package com.dimkafpm.architecture.data.network

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestClientBuilder(val host: String,
                        var connectTimeout: Long = 30,
                        var readTimeout: Long = 30,
                        var dateFormat: String = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'\"") {

    fun build() = Retrofit.Builder()
            .baseUrl(host)
            .client(okHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson()))
            .build()

    private fun okHttpClient() = OkHttpClient.Builder()
            .connectTimeout(connectTimeout, TimeUnit.SECONDS)
            .readTimeout(readTimeout, TimeUnit.SECONDS)
            .build()

    private fun gson() = GsonBuilder()
            .setLenient()
            .setDateFormat(dateFormat)
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
}