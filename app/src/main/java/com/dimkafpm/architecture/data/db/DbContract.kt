package com.dimkafpm.architecture.data.db

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.migration.Migration

object DbContract {
    const val COUNTRY_TABLE_NAME = "country"
    const val COLUMN_ALPHA_2 = "alpha2Code"
    const val COLUMN_ALPHA_3 = "alpha3Code"
    const val COLUMN_NAME = "name"
    const val COLUMN_NATIVE_NAME = "nativeName"
    const val COLUMN_REGION = "region"
    const val COLUMN_CAPITAL = "capital"
    const val COLUMN_BORDERS = "borders"
    const val COLUMN_CURRENCIES = "currencies"
    const val COLUMN_LANGUAGES = "languages"
    const val COLUMN_POPULATION = "population"

    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE $COUNTRY_TABLE_NAME ADD COLUMN $COLUMN_BORDERS TEXT NOT NULL DEFAULT '[]'");
        }
    }
}