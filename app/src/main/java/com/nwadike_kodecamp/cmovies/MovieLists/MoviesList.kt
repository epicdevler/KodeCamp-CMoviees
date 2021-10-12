package com.nwadike_kodecamp.cmovies.MovieLists

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nwadike_kodecamp.cmovies.Adapters.MoviesOptionsListAdapter
import com.nwadike_kodecamp.cmovies.DataSources.MoviesAvailable
import com.nwadike_kodecamp.cmovies.Models.MoviesData
import com.nwadike_kodecamp.cmovies.R
import com.nwadike_kodecamp.cmovies.databinding.MoviesOptionsListActivityBinding

class MoviesList : AppCompatActivity() {
    lateinit var binding: MoviesOptionsListActivityBinding
    lateinit var categoryType: String
    lateinit var recyclerView: RecyclerView
    lateinit var moviesInOptions: ArrayList<MoviesData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MoviesOptionsListActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (intent != null) {
            categoryType = intent.getStringExtra("categoryName").toString()
            moviesInOptions = ArrayList()
            initializeUIElements()

        }

    }

    private fun initializeUIElements() {

        var movies = MoviesAvailable().moviesAvailable()


        binding.screenTitle.text = getString(R.string.showing_movies_in_category, categoryType)

        var isMovieAvailable = false;
        movies.forEachIndexed { _, data ->
            if (data.movieCategoryName != categoryType) {
                setUpRecyclerView()
                return
            } else {
                moviesInOptions.add(data)
                setUpRecyclerView()
                isMovieAvailable = true
            }
        }


    }

    private fun setUpRecyclerView() {
        recyclerView = binding.moviesListRecyclerView;

        if (moviesInOptions.size < 1) {
            binding.errorText.text = getString(R.string.no_movies_for_this_category, categoryType)
            binding.errorContainer.visibility = View.VISIBLE
            binding.moviesListRecyclerView.visibility = View.GONE
            return
        } else {
            recyclerView.setHasFixedSize(false)
//        recyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
            recyclerView.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            recyclerView.adapter = MoviesOptionsListAdapter(moviesInOptions, 1)
        }
    }

}