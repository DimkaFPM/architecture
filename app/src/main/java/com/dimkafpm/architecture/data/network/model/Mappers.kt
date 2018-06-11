package com.dimkafpm.architecture.data.network.model

import com.dimkafpm.architecture.domain.model.Country

fun CountryRemote.toDomain() =
        Country(this.alpha2Code,
        this.alpha3Code,
        this.name,
        this.nativeName,
        this.region,
        this.capital,
        this.currencies,
        this.languages,
        this.population)