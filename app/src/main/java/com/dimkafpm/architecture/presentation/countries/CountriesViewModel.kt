package com.dimkafpm.architecture.presentation.countries

import android.arch.lifecycle.*
import android.content.res.Resources
import com.dimkafpm.architecture.data.CountriesRepo
import com.dimkafpm.architecture.domain.model.Country
import io.reactivex.disposables.Disposable

class CountriesViewModel(private val repository: CountriesRepo) : ViewModel(), LifecycleObserver {

    lateinit var view: CountriesView
    private var state: MainScreenState = MainScreenState.NOT_STARTED_LOADING
    private val visitorsCount = MutableLiveData<List<Country>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun loadCountries() = when (state) {
        MainScreenState.NOT_STARTED_LOADING, MainScreenState.ERROR -> {
            state = MainScreenState.LOADING_COUNTRIES
            repository.getCountries().subscribe(CountriesObserver())
            visitorsCount.observe(view.getLifeCycleOwner(), Observer<List<Country>> { countries -> countries?.run { view.setCountries(this) } })
        }
        else -> visitorsCount.observe(view.getLifeCycleOwner(), Observer<List<Country>> { countries -> countries?.run { view.setCountries(this) } })
    }

    inner class CountriesObserver : io.reactivex.Observer<List<Country>> {
        override fun onComplete() {
            state = MainScreenState.FINISH_LOADING
        }

        override fun onSubscribe(d: Disposable) {
        }

        override fun onNext(countries: List<Country>) {
            visitorsCount.value = countries
        }

        override fun onError(e: Throwable) {
            state = MainScreenState.ERROR
            view.showCountriesNotLoaded({ this@CountriesViewModel.loadCountries() })
        }
    }

    enum class MainScreenState {
        NOT_STARTED_LOADING,
        LOADING_COUNTRIES,
        ERROR,
        FINISH_LOADING
    }
}