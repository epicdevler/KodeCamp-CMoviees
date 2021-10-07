package com.nwadike_kodecamp.cmovies.MovieLists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nwadike_kodecamp.cmovies.R
import com.nwadike_kodecamp.cmovies.databinding.MovieDetailsActivityBinding

class MovieDetails : AppCompatActivity() {
    lateinit var binding: MovieDetailsActivityBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MovieDetailsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}