package com.gautam.movies

import androidx.room.Entity

@Entity
data class Login(
    val name:String,
    val email:String,
    val username:String,
    val password:String
)