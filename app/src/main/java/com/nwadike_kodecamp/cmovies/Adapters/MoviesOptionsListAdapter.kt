package com.nwadike_kodecamp.cmovies.Adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.nwadike_kodecamp.cmovies.Models.MoviesData
import com.nwadike_kodecamp.cmovies.MovieLists.MovieDetails
import com.nwadike_kodecamp.cmovies.R

class MoviesOptionsListAdapter(
    private val moviesInCategory: ArrayList<MoviesData>,
    private val type: Int
) :
    RecyclerView.Adapter<MoviesOptionsListAdapter.CategoriesViewHolder>() {

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        var layoutInflater: View? = null
        layoutInflater = when (type) {
            1 -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.movies_listings_layout, parent, false)
            }
            else -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.movies_listings_grid_layout, parent, false)
            }
        }
        return CategoriesViewHolder(layoutInflater)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val moviesInCategory: MoviesData = moviesInCategory[position]
        val context = holder.itemView.context;
        holder.movieImage.setImageDrawable(
            context.resources.getDrawable(
                moviesInCategory.movieImageUri,
                null
            )
        )
        holder.movieTitle.text = moviesInCategory.movieTitle
        holder.movieReleaseDate.text = moviesInCategory.movieReleaseDate
        holder.itemsContainer.setOnClickListener {
            val intent = Intent(context, MovieDetails::class.java)
            intent.putExtra("category", moviesInCategory.movieCategoryName)
            intent.putExtra("movieID", moviesInCategory.movieID)
            intent.putExtra("imageUri", moviesInCategory.movieImageUri)
            intent.putExtra("movieTitle", moviesInCategory.movieTitle)
            intent.putExtra("movieReleaseDate", moviesInCategory.movieReleaseDate)
            intent.putExtra("movieDetails", moviesInCategory.movieDetails)
            intent.putExtra("webURL", moviesInCategory.movieURL)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return moviesInCategory.size
    }

    class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImage: ImageView = itemView.findViewById(R.id.movieImage)
        val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
        val movieReleaseDate: TextView = itemView.findViewById(R.id.movieReleaseDate)
        val itemsContainer: MaterialCardView = itemView.findViewById(R.id.itemsContainer)
    }

}
