package com.example.movieappcompose.presentation.movie_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappcompose.domain.use_case.get_movie_detail.GetMovieDetailsUseCase
import com.example.movieappcompose.util.Constants.IMDB_ID
import com.example.movieappcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailsUseCase,
    private val savedStateHandle: SavedStateHandle   // Unutma
) : ViewModel()  {

      // State  tanımlaması

    private val _state = mutableStateOf<MovieDetailState>(MovieDetailState())
    val state : State<MovieDetailState> = _state

      //Route da anahtar seklinde yollanıyorsa

    init {
        savedStateHandle.get<String>(IMDB_ID)?.let {
            getMovieDetail(it)
        }
    }


        private fun getMovieDetail(imdbId: String) {
            getMovieDetailUseCase.executeGetMovieDetails(imdbId = imdbId).onEach {   // Flow ise onEach kullanılır
                when (it) {
                    is Resource.Success -> {
                        _state.value = MovieDetailState(movie = it.data)
                    }

                    is Resource.Error -> {
                        _state.value = MovieDetailState(error = it.message ?: "HATA!")

                    }

                    is Resource.Loading -> {
                        _state.value = MovieDetailState(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)
        }

}





