package com.quickupapps.practiceroomdb

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "users")
data class User(
    @PrimaryKey val roll: Int,
    val name: String,
    @TypeConverters(SubjectConverter::class) val subjects: List<Subject>
)

data class Subject(
    val english: Int,
    val maths: Int,
    val science: Int
)

class SubjectConverter {
    @TypeConverter
    fun fromSubjectList(subjects: List<Subject>): String {
        return Gson().toJson(subjects)
    }

    @TypeConverter
    fun toSubjectList(subjectsString: String): List<Subject> {
        val listType = object : TypeToken<List<Subject>>() {}.type
        return Gson().fromJson(subjectsString, listType)
    }
}
