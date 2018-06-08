package com.dimkafpm.architecture.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.dimkafpm.architecture.data.db.DbContract
import com.dimkafpm.architecture.data.db.model.CountryDB

@Dao
interface CountryDao {
    @Query("SELECT * FROM ${DbContract.COUNTRY_TABLE_NAME}")
    fun getAll(): List<CountryDB>

    @Insert
    fun insert(countries: List<CountryDB>)

    @Query("DELETE FROM ${DbContract.COUNTRY_TABLE_NAME}")
    fun clearCountries()
}