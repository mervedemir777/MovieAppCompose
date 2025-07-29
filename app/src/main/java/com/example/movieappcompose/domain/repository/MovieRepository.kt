package com.example.movieappcompose.domain.repository

import com.example.movieappcompose.data.remote.dto.MovieDetailDto
import com.example.movieappcompose.data.remote.dto.MoviesDto

//Fonksiyonları yazıyoruz.

interface MovieRepository {

    suspend fun GetMovies(search: String): MoviesDto

    suspend fun GetMovieDetail(imdbId: String): MovieDetailDto

}