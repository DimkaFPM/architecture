package com.dimkafpm.architecture.di

import android.support.v7.app.AppCompatActivity
import com.tbruyelle.rxpermissions2.RxPermissions
import dagger.Module
import dagger.Provides


@Module
class ActivityModule(val containerId: Int, val activity: AppCompatActivity) {

    @Provides
    @PerActivity
    fun provideRxPermissions(): RxPermissions = RxPermissions(activity)
}