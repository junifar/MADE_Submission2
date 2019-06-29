package com.rubahapi.moviecatalogue


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.rubahapi.moviecatalogue.adapter.MovieAdapter
import com.rubahapi.moviecatalogue.model.Movie
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {

    private var items: MutableList<Movie> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_movie, container, false)
        val list = view.findViewById<RecyclerView>(R.id.recycler_view_movie)

        generateData()

        list.layoutManager = LinearLayoutManager(context)
        list.adapter = MovieAdapter(context, items){
            val intent = Intent(activity, DetailMovieActivity::class.java)
            intent.putExtra(DetailMovieActivity.EXTRA_DETAIL_ACTIVITY_TYPE, DetailMovieActivity.EXTRA_DETAIL_MOVIE)
            intent.putExtra(DetailMovieActivity.EXTRA_DETAIL_MOVIE, it)
            startActivity(intent)
        }

        return view

    }

    private fun generateData(){
        val dataName = resources.getStringArray(R.array.movie_name)
        val dataDescription = resources.getStringArray(R.array.movie_description)
        val dataImage = resources.obtainTypedArray(R.array.movie_photo)
        items.clear()
        for (i in 0 until dataName.size-1){
            items.add(Movie(dataName[i], dataDescription[i], dataImage.getResourceId(i, -1)))
        }
        dataImage.recycle()
    }

    companion object{
        @JvmStatic
        fun newInstance(): MovieFragment {
            return MovieFragment().apply {
                arguments = Bundle().apply {}
            }
        }
    }
}
