package com.rubahapi.moviecatalogue

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.rubahapi.moviecatalogue.model.Movie
import com.rubahapi.moviecatalogue.model.TvShow

class DetailMovieActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DETAIL_MOVIE = "DetailMovies"
        const val EXTRA_DETAIL_TV_SHOW = "DetailTVShow"
        const val EXTRA_DETAIL_ACTIVITY_TYPE = "DetailActovotyType"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val type_activity = intent.getStringExtra(EXTRA_DETAIL_ACTIVITY_TYPE)

        when (type_activity){
            EXTRA_DETAIL_MOVIE -> this.detailMovieInit()
            else -> this.detailTvShowInit()
        }

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {

            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    fun detailTvShowInit(){
        val tvShow = intent.getParcelableExtra<TvShow>(EXTRA_DETAIL_TV_SHOW)

        val image_logo = findViewById<ImageView>(R.id.image_logo)
        val textMovieName = findViewById<TextView>(R.id.textMovieName)
        val textViewDescription = findViewById<TextView>(R.id.textViewDescription)

        image_logo.setImageResource(tvShow.imageUrl)
        textMovieName.text = tvShow.name
        textViewDescription.text = tvShow.description
    }

    fun detailMovieInit(){
        val movie = intent.getParcelableExtra<Movie>(EXTRA_DETAIL_MOVIE)

        val image_logo = findViewById<ImageView>(R.id.image_logo)
        val textMovieName = findViewById<TextView>(R.id.textMovieName)
        val textViewDescription = findViewById<TextView>(R.id.textViewDescription)

        image_logo.setImageResource(movie.imageUrl)
        textMovieName.text = movie.name
        textViewDescription.text = movie.description
    }
}
