package com.dimkafpm.architecture.core.view.recyclerview

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseViewHolder<E>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    constructor(parent: ViewGroup, @LayoutRes layoutRes: Int)
            : this(LayoutInflater.from(parent.context).inflate(layoutRes, parent, false))

    abstract fun bind(item: E)
}
