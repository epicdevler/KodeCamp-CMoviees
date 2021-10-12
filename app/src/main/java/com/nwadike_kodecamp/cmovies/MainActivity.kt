package com.nwadike_kodecamp.cmovies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nwadike_kodecamp.cmovies.Adapters.MoviesCategoriesAdapter
import com.nwadike_kodecamp.cmovies.DataSources.MovieCategories
import com.nwadike_kodecamp.cmovies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var userFullName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getIntentData()
        initializeUIElements()

    }

    private fun initializeUIElements() {
        binding.greetUser.text = getString(R.string.userGreeting, userFullName)
        initializeUIRecyclerView()
    }

    private fun initializeUIRecyclerView() {

        binding.movieCategoryRecycler.setHasFixedSize(false)
        binding.movieCategoryRecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = MoviesCategoriesAdapter(MovieCategories().categories(), 1)
        binding.movieCategoryRecycler.adapter = adapter;
    }

    private fun getIntentData() {
        userFullName = intent.getStringExtra("userFullName").toString()
    }
}