package com.dimkafpm.architecture.presentation.countries

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.widget.TextView
import az.sinam.p2p.presentation.core.viewbinding.bindView
import com.dimkafpm.architecture.R
import com.dimkafpm.architecture.core.extensions.string
import com.dimkafpm.architecture.core.view.recyclerview.BaseRecyclerAdapter
import com.dimkafpm.architecture.core.view.recyclerview.BaseViewHolder
import com.dimkafpm.architecture.domain.model.Country

class CountriesAdapter() : BaseRecyclerAdapter<Country, CountriesAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CountryViewHolder(parent)

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CountryViewHolder(parent: ViewGroup) : BaseViewHolder<Country>(parent, R.layout.list_item_country) {

        private val name: TextView by bindView(R.id.name)
        private val region: TextView by bindView(R.id.region)
        private val capital: TextView by bindView(R.id.capital)
        private val population: TextView by bindView(R.id.population)

        @SuppressLint("SetTextI18n")
        override fun bind(item: Country) {
            name.text = string(R.string.countries_list_name, item.name, item.nativeName)
            region.text = string(R.string.countries_list_region, item.region)
            capital.text = string(R.string.countries_list_capital, item.capital)
            population.text = string(R.string.countries_list_population, item.population)
        }
    }
}