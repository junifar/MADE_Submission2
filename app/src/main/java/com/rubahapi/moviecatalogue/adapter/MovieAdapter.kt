package com.rubahapi.moviecatalogue.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.rubahapi.moviecatalogue.R
import com.rubahapi.moviecatalogue.model.Movie

class MovieAdapter(private val context: Context?, private val items: List<Movie>, private val listener: (Movie) -> Unit):
    RecyclerView.Adapter<MovieAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(context).inflate(
        R.layout.list_item_movie, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindItem(items[position], listener)


    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val name = view.findViewById<TextView>(R.id.listview_item_title)
        private val description = view.findViewById<TextView>(R.id.listview_item_short_description)
        private val image_path = view.findViewById<ImageView>(R.id.image_logo)

        fun bindItem(items: Movie, listener: (Movie) -> Unit){
            name.text = items.name
            description.text = items.description
            image_path.setImageResource(items.imageUrl)
            itemView.setOnClickListener{listener(items)}
        }
    }

}