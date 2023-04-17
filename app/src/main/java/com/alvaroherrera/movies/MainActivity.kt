package com.alvaroherrera.movies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.alvaroherrera.movies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater).apply {

            setContentView(root)
            //recycler.adapter = MoviesAdapter(movies)

            recycler.adapter = MoviesAdapter(movies){ movie ->
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_MOVIE, movie)
                startActivity(intent)
            }
        }


    }

}

private val movies = (1..100).map {
    Movie(
        "Película $it",
        "https://loremflickr.com/240/320/paris?lock=$it")
}

