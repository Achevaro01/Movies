package com.alvaroherrera.movies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alvaroherrera.movies.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_MOVIE = "DetailActivity:Movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = intent?.getParcelableExtra<Movie>(EXTRA_MOVIE) ?: throw IllegalStateException()

        supportActionBar?.title = movie.title

        Glide.with(binding.imagen)
            .load(movie.urlImagen)
            .into(binding.imagen)

    }
}