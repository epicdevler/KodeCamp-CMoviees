package com.nwadike_kodecamp.cmovies.Models

data class MoviesData(
    val movieCategoryName: String,
    val movieID: String,
    val movieImageUri: Int,
    val movieTitle: String,
    val movieReleaseDate: String,
    val movieDetails: String,
    val movieURL: String
)
