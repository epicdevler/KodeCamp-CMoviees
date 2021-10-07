package com.nwadike_kodecamp.cmovies.MovieLists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nwadike_kodecamp.cmovies.databinding.MoviesListActivityBinding

class MoviesList : AppCompatActivity() {
    lateinit var binding : MoviesListActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MoviesListActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Hello

    }
}