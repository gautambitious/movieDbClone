package com.gautam.movies

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance{
    private var retrofit:Retrofit?=null
    private val baseUrl="https://api.themoviedb.org/3/"

    val retrofitInstance:Retrofit?
    get(){
        if(retrofit==null){
            retrofit=retrofit2.Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }

}