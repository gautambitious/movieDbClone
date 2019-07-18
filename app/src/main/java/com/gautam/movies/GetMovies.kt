package com.gautam.movies.com.gautam.movies

import com.gautam.movies.MovieList
import retrofit2.Call
import retrofit2.http.GET

interface GetMovies {
    @GET("movie/now_playing?api_key=8dfb93fdb69f627b174e4f5cb6b4444f&language=en-US&page=1")
    fun getNowShowing():Call<MovieList>
}