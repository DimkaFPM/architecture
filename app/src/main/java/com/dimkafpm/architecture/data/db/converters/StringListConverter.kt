package com.dimkafpm.architecture.data.db.converters

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class StringListConverter {

    private val gson = Gson()

    @TypeConverter
    fun toStringList(data: String?): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun fromStringList(someObjects: List<String>): String {
        return gson.toJson(someObjects)
    }
}