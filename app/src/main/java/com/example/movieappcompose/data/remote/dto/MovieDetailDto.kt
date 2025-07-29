package com.example.movieappcompose.data.remote.dto

import com.example.movieappcompose.domain.model.MovieDetail

data class MovieDetailDto(
    val Actors: String,
    val Awards: String,
    val BoxOffice: String,
    val Country: String,
    val DVD: String,
    val Director: String,
    val Genre: String,
    val Language: String,
    val Metascore: String,
    val Plot: String,
    val Poster: String,
    val Production: String,
    val Rated: String,
    val Ratings: List<Rating>,
    val Released: String,
    val Response: String,
    val Runtime: String,
    val Title: String,
    val Type: String,
    val Website: String,
    val Writer: String,
    val Year: String,
    val imdbID: String,
    val imdbRating: String,
    val imdbVotes: String
)

// Dto kısmında çeviririz göstermek istediğimiz verileri. Göstermek istenilen Modelde durur.
fun MovieDetailDto.toMovieDetail(): MovieDetail {
    return MovieDetail(
        Actors = Actors,
        Awards = Awards,
        Country = Country,
        Director = Director,
        Genre = Genre,
        Language = Language,
        Poster = Poster,
        Rated = Rated,
        Released = Released,
        Title = Title,
        Type = Type,
        Year = Year,
        imdbRating = imdbRating
    )

}