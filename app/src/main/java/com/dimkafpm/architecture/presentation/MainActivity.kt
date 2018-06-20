package com.dimkafpm.architecture.presentation

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import com.dimkafpm.architecture.R
import com.dimkafpm.architecture.presentation.countries.CountriesActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Toolbar>(R.id.toolbar).title = getString(R.string.app_name)

        findViewById<View>(R.id.countries).setOnClickListener { startActivity(Intent(this, CountriesActivity::class.java)) }
    }
}