package com.yusufmendes.movieappcompose.data.repository

import com.yusufmendes.movieappcompose.data.remote.MovieAPI
import com.yusufmendes.movieappcompose.data.remote.dto.MovieDetailDto
import com.yusufmendes.movieappcompose.data.remote.dto.MoviesDto
import com.yusufmendes.movieappcompose.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val movieAPI: MovieAPI) : MovieRepository {
    override suspend fun getMovies(search: String): MoviesDto = movieAPI.getMovies(search = search)

    override suspend fun getDetailMovie(imdbId: String): MovieDetailDto =
        movieAPI.getMovieDetail(imdbId = imdbId)
}