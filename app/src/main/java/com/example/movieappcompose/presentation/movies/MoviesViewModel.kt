package com.example.movieappcompose.presentation.movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappcompose.domain.use_case.get_movies.GetMovieUseCase
import com.example.movieappcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor (
    private val getMovieUseCase: GetMovieUseCase,
) : ViewModel() {


    private val _state = mutableStateOf<MoviesState>(MoviesState())   // Bu private
    val state: State<MoviesState> = _state     // Private değil

    private var job: Job? = null    // Arama yaparken daha önce bir şey varsa sil. Kullanıcı cok hızlı search yapabilir.

    //İlk açıldığında direkt çalışır

    init {
        getMovies(_state.value.search)
    }


    private fun getMovies(search: String) {

        job?.cancel()  // Silinen yer

        job = getMovieUseCase.executeGetMovies(search = search).onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = MoviesState(movies = it.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = MoviesState(error = it.message ?: "Hata!")
                }

                is Resource.Loading -> {
                    _state.value = MoviesState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)     // Unutma


        //Kullanıcı etkileşime geçtiğinde kullanılacak

        fun onEvent(event: MoviesEvent) {
            when (event) {
                is MoviesEvent.Search -> {
                    getMovies(event.searchString)
                }
            }
        }
    }


}
