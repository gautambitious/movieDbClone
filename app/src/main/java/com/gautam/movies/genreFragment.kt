package com.gautam.movies

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.gautam.movies.R
import com.google.gson.GsonBuilder
import okhttp3.*
import org.jetbrains.anko.support.v4.runOnUiThread
import java.io.IOException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
val apiKey="8dfb93fdb69f627b174e4f5cb6b4444f"
class genreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getGenre()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_genre, container, false)
    }

    fun getGenre(){
        val client = OkHttpClient()
        var res=""
        val url="https://api.themoviedb.org/3/genre/movie/list?api_key=$apiKey&language=en-US"
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.i("workk","didn't work lol")
            }

            override fun onResponse(call: Call, response: Response) {
                res = response.body?.string()!!
                Log.i("workk",res)
                val gson=GsonBuilder().create()

                val gen=gson.fromJson(res,Array<genres>::class.java)
                runOnUiThread {
                    var names=gen.size
                Log.i("workk",names.toString())}
            }

        })


    }
}
