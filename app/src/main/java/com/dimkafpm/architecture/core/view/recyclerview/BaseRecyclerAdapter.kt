package com.dimkafpm.architecture.core.view.recyclerview

import android.support.v7.widget.RecyclerView

abstract class BaseRecyclerAdapter<E, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    open var items: List<E> = ArrayList()
        set(entities) {
            field = ArrayList(entities)
            notifyDataSetChanged()
        }

    protected val modelsCount
        get() = items.size

    fun getItem(position: Int) = items[position]

    override fun getItemCount() = modelsCount
}
