package com.dimkafpm.architecture.data.db.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.dimkafpm.architecture.data.db.DbContract
import com.dimkafpm.architecture.data.db.converters.StringListConverter

@TypeConverters(value = [StringListConverter::class])
@Entity(tableName = DbContract.COUNTRY_TABLE_NAME)
data class CountryDB(val alpha2Code: String,
                     @PrimaryKey val alpha3Code: String,
                     val name: String,
                     val nativeName: String,
                     val region: String,
                     val capital: String,
                     val currencies: List<String>,
                     val languages: List<String>,
                     val population: Int)