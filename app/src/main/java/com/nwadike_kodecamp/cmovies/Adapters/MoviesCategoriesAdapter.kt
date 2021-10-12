package com.nwadike_kodecamp.cmovies.Adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.nwadike_kodecamp.cmovies.Models.MoviesCategories
import com.nwadike_kodecamp.cmovies.MovieLists.MoviesList
import com.nwadike_kodecamp.cmovies.R

class MoviesCategoriesAdapter(
    private val categoriesArray: Array<MoviesCategories>,
    private val type: Int
) :
    RecyclerView.Adapter<MoviesCategoriesAdapter.CategoriesViewHolder>() {

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        var layoutInflater: View? = null
        layoutInflater = when (type) {
            1 -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.movies_categories_listings_layout, parent, false)
            }
            else -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.movies_categories_listings_grid_layout, parent, false)
            }
        }
        return CategoriesViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val moviesCategories: MoviesCategories = categoriesArray[position]
        val context = holder.itemView.context;
        holder.textView.text = moviesCategories.alphabeticTitle
        holder.itemsContainer.setOnClickListener {
            val intent = Intent(context, MoviesList::class.java)
            intent.putExtra("categoryName", moviesCategories.alphabeticTitle)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return categoriesArray.size
    }

    class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.categoryID)
        val itemsContainer: MaterialCardView = itemView.findViewById(R.id.itemsContainer)
    }

}
