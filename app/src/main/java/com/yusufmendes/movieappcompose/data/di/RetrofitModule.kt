package com.yusufmendes.movieappcompose.data.di

import com.yusufmendes.movieappcompose.data.remote.MovieAPI
import com.yusufmendes.movieappcompose.data.repository.MovieRepositoryImpl
import com.yusufmendes.movieappcompose.domain.repository.MovieRepository
import com.yusufmendes.movieappcompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideMovieApi(): MovieAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(movieAPI: MovieAPI): MovieRepository =
        MovieRepositoryImpl(movieAPI = movieAPI)
}