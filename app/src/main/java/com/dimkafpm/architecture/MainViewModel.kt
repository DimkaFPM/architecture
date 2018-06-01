package com.dimkafpm.architecture

import android.arch.lifecycle.*
import io.reactivex.disposables.Disposable

class MainViewModel(private val repository: MainRepository = MainRepository()) : ViewModel(), LifecycleObserver {

    lateinit var view: MainView
    private var state: MainScreenState = MainScreenState.NOT_STARTED_MONITORING
    private val visitorsCount = MutableLiveData<Long>()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun monitorStopWatch() = when(state) {
        MainScreenState.NOT_STARTED_MONITORING -> {
            state = MainScreenState.IN_PROCESS_OF_MONITORING
            repository.getVisitorsCountObservable().subscribe(VisitorsCountObserver())
            visitorsCount.observe(view.getLifeCycleOwner(), Observer<Long> { count -> count?.run { view.setCount(this) } })
        }
        MainScreenState.IN_PROCESS_OF_MONITORING -> {
            visitorsCount.observe(view.getLifeCycleOwner(), Observer<Long> { count -> count?.run { view.setCount(this) } })
        }
        MainScreenState.FINISH_MONITORING -> view.setCount(100500)
    }

    inner class VisitorsCountObserver : io.reactivex.Observer<Long> {
        override fun onComplete() {
            state = MainScreenState.FINISH_MONITORING
        }

        override fun onSubscribe(d: Disposable) {
        }

        override fun onNext(t: Long) {
            visitorsCount.value = t
        }

        override fun onError(e: Throwable) {
            throw IllegalStateException(e)
        }
    }

    enum class MainScreenState {
        NOT_STARTED_MONITORING,
        IN_PROCESS_OF_MONITORING,
        FINISH_MONITORING
    }
}