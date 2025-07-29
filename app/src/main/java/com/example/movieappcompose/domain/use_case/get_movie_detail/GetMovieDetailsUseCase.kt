package com.example.movieappcompose.domain.use_case.get_movie_detail

import com.example.movieappcompose.data.remote.dto.toMovieDetail
import com.example.movieappcompose.domain.model.MovieDetail
import com.example.movieappcompose.domain.repository.MovieRepository
import com.example.movieappcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

//Use caselerde tek fonk yazılır.
class GetMovieDetailsUseCase  @Inject constructor(private val repository : MovieRepository) {

    fun executeGetMovieDetails(imdbId: String) : Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repository.GetMovieDetail(imdbId =imdbId)  // Filmlerin detaylarını getirme
            emit(Resource.Success(movieDetail.toMovieDetail()))  // Çevirme işlemi
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Hata!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "İnternet yok"))
        }
    }
}

