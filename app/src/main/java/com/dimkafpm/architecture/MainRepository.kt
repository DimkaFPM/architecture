package com.dimkafpm.architecture

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MainRepository {

    fun getVisitorsCountObservable() = Observable.interval(1, TimeUnit.SECONDS)
            .take(10)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}