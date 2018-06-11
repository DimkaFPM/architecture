package com.dimkafpm.architecture.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.dimkafpm.architecture.data.db.dao.CountryDao
import com.dimkafpm.architecture.data.db.model.CountryDB

@Database(entities = [CountryDB::class], version = 1)
abstract class DbDataSource : RoomDatabase() {
    abstract fun countryDao(): CountryDao
}