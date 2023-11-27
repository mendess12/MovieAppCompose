package com.yusufmendes.movieappcompose.domain.repository

import com.yusufmendes.movieappcompose.data.remote.dto.MovieDetailDto
import com.yusufmendes.movieappcompose.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(search: String): MoviesDto

    suspend fun getDetailMovie(imdbId: String): MovieDetailDto
}