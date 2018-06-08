package com.dimkafpm.architecture.data.network.model

fun CountryRemote.toDomain() = com.dimkafpm.architecture.domain.model.Country(this.name,
        this.nativeName,
        this.region,
        this.capital,
        this.currencies,
        this.languages,
        this.population)