package com.gautam.movies

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface loginDao{
    @Insert
    fun insertRow(login:Login)

    @Query("Select password from Login where username=:username")
    fun getPassword(username:String):String
}