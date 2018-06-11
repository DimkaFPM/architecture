package com.dimkafpm.architecture.core.viewbinding

import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun <T : View> ViewHolder.bindView(id: Int) = ViewHolderBindViewDelegate<T>(this, id)

class ViewHolderBindViewDelegate<out T : View>(private val viewHolder: ViewHolder, private val id: Int) : ReadOnlyProperty<Any?, T> {

    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        if (value == null) {
            value = viewHolder.itemView.findViewById(id) as T
        }

        return value as T
    }
}