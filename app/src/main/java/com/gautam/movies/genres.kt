package com.gautam.movies

data class genres(
    val id:Int,
    val name:String
)
data class allGenre(
    val genres: ArrayList<genres>
)