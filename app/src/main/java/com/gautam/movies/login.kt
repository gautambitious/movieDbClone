package com.gautam.movies

import androidx.room.Entity

@Entity
data class login(
    val username:String,
    val password:String
)