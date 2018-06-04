package com.dimkafpm.architecture.di

import com.dimkafpm.architecture.presentation.countries.CountriesActivity
import dagger.Component

@PerActivity
@Component(dependencies = [(AppComponent::class)])
interface ActivityComponent {

    fun inject(activity: CountriesActivity)
}