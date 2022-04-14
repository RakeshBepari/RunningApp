package com.example.runningapp.db

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(
    entities = [Run::class],version = 1, exportSchema = false
)
@TypeConverters(Converters::class)
abstract class RunningDatabase: RoomDatabase() {

    abstract fun getRunDao():RunDao

    
}