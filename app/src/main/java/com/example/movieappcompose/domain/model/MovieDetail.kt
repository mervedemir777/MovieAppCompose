package com.example.movieappcompose.domain.model

import com.example.movieappcompose.data.remote.dto.Rating

// Yeniden göstermek istediğimiz verileri tutar. Daha sonra cevırırız dto ıcınde

data class MovieDetail(
    val Actors: String,
    val Awards: String,
    val Country: String,
    val Director: String,
    val Genre: String,
    val Language: String,
    val Poster: String,
    val Rated: String,
    val Released: String,
    val Title: String,
    val Type: String,
    val Year: String,
    val imdbRating: String,

)
