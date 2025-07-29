package com.example.movieappcompose.presentation

import android.os.Parcel
import android.os.Parcelable

// Navigation için. Route yazarken burdan "screen.route.sayfanınadı" şeklinde yazılır

sealed class Screen(val route: String) {

    object MovieScreen : Screen("movie_screen")
    object MovieDetailScreen : Screen("movie_detail_screen")

}