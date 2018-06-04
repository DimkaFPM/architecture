package com.dimkafpm.architecture.presentation.countries

import com.dimkafpm.architecture.domain.model.Country
import com.dimkafpm.architecture.presentation.BaseView

interface CountriesView : BaseView {
    fun setCountries(countries: List<Country>)
    fun showCountriesNotLoaded(retryCallback: () -> Unit)
}