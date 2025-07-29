package com.example.movieappcompose.data.remote

import com.example.movieappcompose.data.remote.dto.MovieDetailDto
import com.example.movieappcompose.data.remote.dto.MoviesDto
import com.example.movieappcompose.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

//Retrofit isteği yapılır. App için hangi istekler gerekirse onlar vardır

interface MovieAPI {

    abstract fun getMovies(searchString: String): MoviesDto
    abstract fun getMovieDetail(imdbId: String): MovieDetailDto

    interface MovieAPI {

        //https://omdbapi.com/?apikey=2d6a09f9&s=batman
        //https://omdbapi.com/?apikey=2d6a09f9&i=tt0372784

        @GET(".")    // Base urlden sonra bır sey yazmadıgı ıcın sadece . koyulabilir
        suspend fun getMovies(   //Filmleri alma
            @Query("s") searchString :String,
            @Query("apikey") apiKey :String = API_KEY
        ) : MoviesDto

        @GET(".")
        suspend fun getMovieDetail(   //Detayları alma
            @Query("i") imdbId : String,
            @Query("apikey") apiKey: String = API_KEY
        ) : MovieDetailDto

    }
}