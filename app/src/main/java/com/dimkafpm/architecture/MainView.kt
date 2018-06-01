package com.dimkafpm.architecture

import android.arch.lifecycle.LifecycleOwner

interface MainView {
    fun setCount(count: Long)
    fun getLifeCycleOwner() : LifecycleOwner
}