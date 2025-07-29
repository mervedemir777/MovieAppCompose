package com.example.movieappcompose.data.dependencyinjection

import com.example.movieappcompose.data.remote.MovieAPI
import com.example.movieappcompose.data.repository.MovieRepositoryImpl
import com.example.movieappcompose.domain.repository.MovieRepository
import com.example.movieappcompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// Dagger Hilt her şeyi otomatik enjekte eder.

@Module
@InstallIn(SingletonComponent::class)  // Hangi yaşam döngüsüne sahip olacağını belirtir.
                    // Uygulama çalıştığı sürece bu nesneleri tek bir kez oluşturur, her yerde aynı nesneyi kullanır
object AppModule {

    //API retrofit yazılır

    @Provides
    @Singleton
    fun provideMovieApi(): MovieAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())  //gelen JSON verisini Kotlin nesnelerine dönüştürür
            .build()
            .create(MovieAPI::class.java)
        // Retrofit servisini ayarlayıp, MovieAPI nesnesini sağlamaktır.

    }


    @Provides
    @Singleton
    fun provideMovieRepository(api: MovieAPI): MovieRepository {
        return MovieRepositoryImpl(api = api)

    // Verileri internetten almak, işlemek ve ViewModel’a sunmak için bir Repository katmanı oluşturur.
    }
}