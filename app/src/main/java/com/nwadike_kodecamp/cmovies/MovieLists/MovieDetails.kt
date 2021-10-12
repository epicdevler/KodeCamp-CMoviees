package com.nwadike_kodecamp.cmovies.MovieLists

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nwadike_kodecamp.cmovies.databinding.MovieDetailsActivityBinding

class MovieDetails : AppCompatActivity() {
    lateinit var binding: MovieDetailsActivityBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MovieDetailsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeUIElements()

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun initializeUIElements() {

//        intent.putExtra("category", moviesInCategory.movieCategoryName)
//        intent.putExtra("movieID", moviesInCategory.movieID)
    //        intent.putExtra("imageUri", moviesInCategory.movieImageUri)
//        intent.putExtra("movieTitle", moviesInCategory.movieTitle)
//        intent.putExtra("movieReleaseDate", moviesInCategory.movieReleaseDate)
//        intent.putExtra("movieDetails", moviesInCategory.movieDetails)
//        intent.putExtra("webURL", moviesInCategory.movieDetails)

        if (intent != null) {
            binding.imageView.setImageDrawable(resources.getDrawable(intent.getStringExtra("imageUri")!!.toInt(), null))
            binding.releaseDate.text = intent.getStringExtra("movieReleaseDate")
            binding.title.text = intent.getStringExtra("movieTitle")
            binding.details.text = intent.getStringExtra("movieDetails")

            binding.readOnlince.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(intent.getStringExtra("webURL").toString()))
                startActivity(intent)
            }

        }

    }
}