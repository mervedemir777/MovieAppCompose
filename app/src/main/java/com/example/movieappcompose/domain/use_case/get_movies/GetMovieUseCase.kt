package com.example.movieappcompose.domain.use_case.get_movies

import android.os.Parcel
import android.os.Parcelable
import com.example.movieappcompose.data.remote.dto.toMovieList
import com.example.movieappcompose.domain.model.Movie
import com.example.movieappcompose.domain.repository.MovieRepository
import com.example.movieappcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

//Use caselerde sadece tek fonksiyonlar yazılır
//Resource loading, error, success döndürür

class GetMovieUseCase  @Inject constructor(private val repository : MovieRepository) {

    fun executeGetMovies(search: String) : Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList = repository.GetMovies(search = search) //Listeden çekiyoruz
            if(movieList.Response.equals("True")) {
                emit(Resource.Success(movieList.toMovieList()))  //Dtodan cevırdıgımız lıste gelır yanı cevırırız toMovieList diyerek.
            } else {
                emit(Resource.Error(message = "Film bulunamadı"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Hata!"))  //Sunucudan gelen hata (örneğin 404, 500 gibi HTTP hataları)
        } catch (e: IOError) {
            emit(Resource.Error(message = "İnternet yok"))
        }
    }

}