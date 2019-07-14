package com.gautam.movies

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Login(
    val name:String,
    @PrimaryKey
    val email:String,
    val password:String
)