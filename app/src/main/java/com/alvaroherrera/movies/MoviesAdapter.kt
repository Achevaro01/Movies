package com.alvaroherrera.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvaroherrera.movies.databinding.ViewMovieBinding
import com.bumptech.glide.Glide


class MoviesAdapter(
    val movies: List<Movie>,
    val listener: (Movie) -> Unit
) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_movie, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
        val movie = movies[position]
        holder.bind(movie)

        holder.itemView.setOnClickListener {
            listener(movie)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ViewMovieBinding.bind(view)
        fun bind(movie: Movie) {
            binding.title.text = movie.title

            Glide.with(binding.imagen)
                .load(movie.urlImagen)
                .into(binding.imagen)
        }
    }
}