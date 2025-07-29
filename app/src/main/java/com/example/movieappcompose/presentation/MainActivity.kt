package com.example.movieappcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieappcompose.presentation.movie_detail.views.MovieDetailScreen
import com.example.movieappcompose.presentation.movies.views.MovieScreen
import com.example.movieappcompose.ui.theme.MovieAppComposeTheme
import com.example.movieappcompose.util.Constants.IMDB_ID
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint    //UNUTMA İlk sayfanın burdan açılacağını belirtir.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieAppComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController,
                        startDestination = Screen.MovieScreen.route
                    ) {
                        composable(route = Screen.MovieScreen.route) {    // İlk sayfa
                            MovieScreen(navController = navController)
                        }

                        composable(route = Screen.MovieDetailScreen.route+"/{${IMDB_ID}}") {   // İkinci sayfa unutma id de yazılmalı
                            MovieDetailScreen()
                        }
                    }
                }
            }
        }
    }
}


