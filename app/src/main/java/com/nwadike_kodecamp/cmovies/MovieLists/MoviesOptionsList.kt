package com.nwadike_kodecamp.cmovies.MovieLists

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nwadike_kodecamp.cmovies.databinding.MoviesOptionsListActivityBinding

class MoviesOptionsList : AppCompatActivity() {
    lateinit var binding: MoviesOptionsListActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MoviesOptionsListActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}
