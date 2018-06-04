package com.dimkafpm.architecture.presentation

import android.arch.lifecycle.LifecycleOwner

interface BaseView {
    fun getLifeCycleOwner(): LifecycleOwner
    fun showError(text: CharSequence, retryCallback: () -> Unit)
}