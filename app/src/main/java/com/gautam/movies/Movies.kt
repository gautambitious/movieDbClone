package com.gautam.movies

import com.google.gson.annotations.SerializedName
import java.sql.RowId

data class Movie(
    val title:String,
    val adult:Boolean,
    val id: Int,
    @SerializedName("vote_average")
    val rating:Double,
    val poster_path:String,
    val genre_ids: ArrayList<Int>,
    val release_date:String,
    val overview:String
)

data class MovieList(
    @SerializedName("results")
    val movies:ArrayList<Movie>
)
//"vote_count": 1910,
//"id": 429617,
//"video": false,
//"vote_average": 7.8,
//"title": "Spider-Man: Far from Home",
//"popularity": 417.77,
//"poster_path": "/rjbNpRMoVvqHmhmksbokcyCr7wn.jpg",
//"original_language": "en",
//"original_title": "Spider-Man: Far from Home",
//"genre_ids": [
//28,
//12,
//878
//],
//"backdrop_path": "/dihW2yTsvQlust7mSuAqJDtqW7k.jpg",
//"adult": false,
//"overview": "Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.",
//"release_date": "2019-06-28"