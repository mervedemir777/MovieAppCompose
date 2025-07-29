package com.example.movieappcompose.presentation.movies

import com.example.movieappcompose.domain.model.Movie

// Veri tutulan parametreler vardır.

data class MoviesState(
    val isLoading : Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error : String = "",
    val search : String = "batman"  //İlk açıldığında çıkar, search kısmında yazar
)
