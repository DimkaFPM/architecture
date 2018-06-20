package com.dimkafpm.architecture.presentation.countries

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import com.dimkafpm.architecture.R
import com.dimkafpm.architecture.core.extensions.app
import com.dimkafpm.architecture.di.DaggerActivityComponent
import com.dimkafpm.architecture.domain.model.Country
import javax.inject.Inject

class CountriesActivity : AppCompatActivity(), CountriesView {

    @Inject
    lateinit var countriesModelFactory: CountriesModelFactory
    private lateinit var viewModel: CountriesViewModel

    private lateinit var root: View
    private lateinit var toolbar: Toolbar

    private lateinit var countries: RecyclerView
    private lateinit var countriesAdapter: CountriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        createActivityComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)

        root = findViewById(R.id.root)

        toolbar = findViewById(R.id.toolbar)
        toolbar.title = getString(R.string.countries_list_screen_title)

        countries = findViewById(R.id.countries)
        countries.layoutManager = LinearLayoutManager(this)
        countriesAdapter = CountriesAdapter()
        countries.adapter = countriesAdapter

        viewModel = ViewModelProviders.of(this, countriesModelFactory).get(CountriesViewModel::class.java)
        viewModel.view = this
        lifecycle.addObserver(viewModel)
    }

    private fun createActivityComponent() = DaggerActivityComponent.builder()
            .appComponent(app.getAppComponent())
            .build()

    override fun setCountries(countries: List<Country>) {
        countriesAdapter.items = countries
    }

    override fun getLifeCycleOwner(): LifecycleOwner = this

    override fun showCountriesNotLoaded(retryCallback: () -> Unit) = showError(getString(R.string.countries_list_error), retryCallback)

    override fun showError(text: CharSequence, retryCallback: () -> Unit) {
        Snackbar.make(root, text, Snackbar.LENGTH_LONG)
                .setAction(R.string.retry, { retryCallback.invoke() })
                .show()
    }
}
