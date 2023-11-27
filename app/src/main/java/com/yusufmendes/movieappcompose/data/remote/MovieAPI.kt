package com.yusufmendes.movieappcompose.data.remote

import com.yusufmendes.movieappcompose.data.remote.dto.MovieDetailDto
import com.yusufmendes.movieappcompose.data.remote.dto.MoviesDto
import com.yusufmendes.movieappcompose.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    @GET(".")
    suspend fun getMovies(
        @Query("s") search: String,
        @Query("apikey") apiKey: String = API_KEY
    ): MoviesDto

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId: String,
        @Query("apikey") apiKey: String = API_KEY
    ): MovieDetailDto
}