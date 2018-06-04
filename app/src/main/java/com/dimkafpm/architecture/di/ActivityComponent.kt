package com.dimkafpm.architecture.di

import dagger.Component

@PerActivity
@Component(dependencies = [(AppComponent::class)], modules = [(ActivityModule::class)])
interface ActivityComponent {
}