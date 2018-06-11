package com.dimkafpm.architecture.data.db.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.dimkafpm.architecture.data.db.DbContract
import com.dimkafpm.architecture.data.db.converters.StringListConverter

@TypeConverters(value = [StringListConverter::class])
@Entity(tableName = DbContract.COUNTRY_TABLE_NAME)
data class CountryDB(@ColumnInfo(name = DbContract.COLUMN_ALPHA_2) val alpha2Code: String,
                     @ColumnInfo(name = DbContract.COLUMN_ALPHA_3) @PrimaryKey val alpha3Code: String,
                     @ColumnInfo(name = DbContract.COLUMN_NAME) val name: String,
                     @ColumnInfo(name = DbContract.COLUMN_NATIVE_NAME) val nativeName: String,
                     @ColumnInfo(name = DbContract.COLUMN_REGION) val region: String,
                     @ColumnInfo(name = DbContract.COLUMN_CAPITAL) val capital: String,
                     @ColumnInfo(name = DbContract.COLUMN_BORDERS) val borders: List<String>,
                     @ColumnInfo(name = DbContract.COLUMN_CURRENCIES) val currencies: List<String>,
                     @ColumnInfo(name = DbContract.COLUMN_LANGUAGES) val languages: List<String>,
                     @ColumnInfo(name = DbContract.COLUMN_POPULATION) val population: Int)