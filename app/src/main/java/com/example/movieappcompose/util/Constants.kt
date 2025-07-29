package com.example.movieappcompose.util


// Sabitler yazılır

object Constants {

    // http://www.omdbapi.com/?i=tt3896198&apikey=2d6a09f9

    const val API_KEY =  "2d6a09f9"
    const val BASE_URL = "http://www.omdbapi.com/"
    const val IMDB_ID = "imdb_id"

}


// http olduğu için yeni xml dosyası oluşturulur. http güvenli değil saldırılara açııktır.


/*    android:usesCleartextTraffic="true"
      android:networkSecurityConfig="@xml/network_security_config"  */