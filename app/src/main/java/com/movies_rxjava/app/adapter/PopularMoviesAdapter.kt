package com.movies_rxjava.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.movies_rxjava.R
import com.movies_rxjava.databinding.PopularMovieItemBinding
import com.movies_rxjava.remote.model.Movie

class PopularMoviesAdapter(
    private val clickListener: (Movie) -> Unit
) : RecyclerView.Adapter<PopularMoviesVH>() {

    private val popularMoviesList: MutableList<Movie> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: PopularMovieItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.popular_movie_item, parent, false)
        return PopularMoviesVH(binding)
    }

    override fun getItemCount() = popularMoviesList.size

    override fun onBindViewHolder(holder: PopularMoviesVH, position: Int) {
        holder.bind(popularMoviesList[position], clickListener)
    }

    fun populate(popularMovies: List<Movie>) {
        popularMoviesList.clear()
        popularMoviesList.addAll(popularMovies)
        notifyDataSetChanged()
    }
}

class PopularMoviesVH(private val binding: PopularMovieItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie, clickListener: (Movie) -> Unit) {
        binding.textTitle.text = movie.title
        binding.cardMovie.setOnClickListener {
            clickListener(movie)
        }
    }
}