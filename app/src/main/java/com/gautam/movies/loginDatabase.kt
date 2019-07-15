package com.gautam.movies

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Login::class),version = 1)
abstract class loginDatabase : RoomDatabase() {
    abstract fun loginDao(): LoginDao

    companion object {
        fun createDatabase(context: Context):loginDatabase
                = Room.databaseBuilder(context,loginDatabase::class.java, "users.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}

