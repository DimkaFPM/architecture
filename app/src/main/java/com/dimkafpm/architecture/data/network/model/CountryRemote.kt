package com.dimkafpm.architecture.data.network.model

import com.google.gson.annotations.SerializedName

class CountryRemote(@SerializedName("alpha2Code") val alpha2Code: String,
                    @SerializedName("alpha3Code") val alpha3Code: String,
                    @SerializedName("name") val name: String,
                    @SerializedName("nativeName") val nativeName: String,
                    @SerializedName("region") val region: String,
                    @SerializedName("capital") val capital: String,
                    @SerializedName("borders") val borders: List<String>,
                    @SerializedName("currencies") val currencies: List<String>,
                    @SerializedName("languages")  val languages: List<String>,
                    @SerializedName("population") val population: Int)