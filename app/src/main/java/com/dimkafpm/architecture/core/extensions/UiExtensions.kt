package com.dimkafpm.architecture.core.extensions

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.util.DisplayMetrics
import android.view.WindowManager
import com.dimkafpm.architecture.App

val Context.app: App
    get() = this.applicationContext as App

val Context.displayMetrics: DisplayMetrics
    get() {
        val metrics = DisplayMetrics()
        val windowManager = this.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.defaultDisplay.getMetrics(metrics)
        return metrics
    }

val RecyclerView.ViewHolder.context: Context
    get() = itemView.context

fun RecyclerView.ViewHolder.string(@StringRes strRes: Int) = context.getString(strRes)
fun RecyclerView.ViewHolder.string(@StringRes strRes: Int, vararg params: Any) = context.getString(strRes, *params)

fun RecyclerView.setDivider(@DrawableRes drawableRes: Int) {
    val itemDecorator = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
    itemDecorator.setDrawable(ContextCompat.getDrawable(context, drawableRes)!!)
    addItemDecoration(itemDecorator)
}

