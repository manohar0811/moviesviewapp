package com.example.moviesviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MovieAdapter(private val movies: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val yearTextView: TextView = itemView.findViewById(R.id.yearTextView)
        val directorTextView: TextView = itemView.findViewById(R.id.directorTextView)
        val actorsTextView: TextView = itemView.findViewById(R.id.actorsTextView)
        val plotTextView: TextView = itemView.findViewById(R.id.plotTextView)
        val posterImageView: ImageView = itemView.findViewById(R.id.posterImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.titleTextView.text = movie.title
        holder.yearTextView.text = movie.year

        // Display additional details
        holder.directorTextView.text = "Director: ${movie.director}"
        holder.actorsTextView.text = "Actors: ${movie.actors}"
        holder.plotTextView.text = "Plot: ${movie.plot}"

        // Load poster image using Picasso
        Picasso.get().load(movie.posterUrl).into(holder.posterImageView)
    }

    override fun getItemCount(): Int = movies.size
}
