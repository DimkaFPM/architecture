package com.dimkafpm.architecture.data.db.model

import com.dimkafpm.architecture.domain.model.Country

fun CountryDB.toDomain() = Country(this.alpha2Code,
        this.alpha3Code,
        this.name,
        this.nativeName,
        this.region,
        this.capital,
        this.currencies,
        this.languages,
        this.population)

fun fromDomain(country: Country) = CountryDB(country.alpha2Code,
        country.alpha3Code,
        country.name,
        country.nativeName,
        country.region,
        country.capital,
        country.currencies,
        country.languages,
        country.population)