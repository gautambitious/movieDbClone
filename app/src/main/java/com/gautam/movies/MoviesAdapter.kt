package com.gautam.movies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.nowshowing_layout.view.*

class MoviesAdapter(val movie: ArrayList<Movie>,val context:Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater= LayoutInflater.from(context)
        val view=inflater.inflate(R.layout.nowshowing_layout,parent,false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movie.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mov=movie[position]
        holder.itemView.apply {
            movieTitleText.text=mov.title
        }
    }

}
class MoviesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
