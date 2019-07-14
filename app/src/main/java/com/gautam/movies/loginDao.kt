package com.gautam.movies

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LoginDao{
    @Insert
    fun insertRow(login:Login)

    @Query("Select password from Login where email=:username")
    fun getPassword(username:String):String

    @Query("Select name from Login where email=:email")
    fun getName(email:String):String

}