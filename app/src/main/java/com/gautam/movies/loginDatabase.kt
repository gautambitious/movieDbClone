package com.gautam.movies

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Login::class),version = 1)
abstract class loginDatabase : RoomDatabase() {
    abstract fun loginDao(): LoginDao
}
