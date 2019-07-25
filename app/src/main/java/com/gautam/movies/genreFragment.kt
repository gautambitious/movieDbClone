package com.gautam.movies

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_genre.*
import kotlinx.android.synthetic.main.fragment_genre.view.*
import kotlinx.coroutines.android.awaitFrame
import kotlinx.coroutines.awaitAll
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
    lateinit var adapter:ArrayAdapter<String>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_genre, container, false)
        adapter=ArrayAdapter<String>(requireContext(),android.R.layout.simple_list_item_1,getGenre())
        view.genreListView.adapter=adapter
        return view
    }

    fun getGenre() :ArrayList<String> {
        val list= arrayListOf<String>()
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
                val gson=GsonBuilder().create()
                val gen=gson.fromJson(res,allGenre::class.java)
                for (i in 0 until gen.genres.size){
                    list.add(gen.genres[i].name)
                }
                runOnUiThread {
                    adapter.notifyDataSetChanged()
                }
            }
        })
        return list
    }
}
