package com.dimkafpm.architecture

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var countTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        countTextView = findViewById(R.id.count)

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.view = this
        lifecycle.addObserver(viewModel)
    }

    override fun setCount(count: Long) {
        countTextView.text = "Count: $count"
    }

    override fun getLifeCycleOwner(): LifecycleOwner = this
}
