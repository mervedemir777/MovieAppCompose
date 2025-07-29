package com.example.movieappcompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Manifest içine eklemeyi unutma

@HiltAndroidApp
class MovieApplication : Application()  {
}