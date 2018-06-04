package com.dimkafpm.architecture.presentation.countries

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.dimkafpm.architecture.data.CountriesRepo
import javax.inject.Inject


class CountriesModelFactory @Inject constructor(private val countriesRepo: CountriesRepo) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = when (modelClass) {
        CountriesViewModel::class.java -> CountriesViewModel(countriesRepo) as T
        else -> super.create(modelClass)
    }
}