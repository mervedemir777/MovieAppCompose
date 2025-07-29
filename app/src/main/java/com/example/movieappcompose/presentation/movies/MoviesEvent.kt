package com.example.movieappcompose.presentation.movies

// Kullanıcının yaptığı aktiviteler (search, click) vb.
// Her zaman olmayabilir etkileşim yoksa yoktur
// sealed olmazsa dıger sınıflarda erişilebilir

sealed class MoviesEvent {
    data class Search (val searchString: String) : MoviesEvent()
}