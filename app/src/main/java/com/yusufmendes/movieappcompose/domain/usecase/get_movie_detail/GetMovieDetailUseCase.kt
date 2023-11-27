package com.yusufmendes.movieappcompose.domain.usecase.get_movie_detail

import com.yusufmendes.movieappcompose.data.remote.dto.toMovieDetail
import com.yusufmendes.movieappcompose.domain.model.MovieDetail
import com.yusufmendes.movieappcompose.domain.repository.MovieRepository
import com.yusufmendes.movieappcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    fun executeGetMovieDetail(imdbId: String): Flow<Resource<MovieDetail>> {
        return flow {
            try {
                emit(Resource.Loading())
                val movieDetail = movieRepository.getDetailMovie(imdbId)
                emit(Resource.Success(movieDetail.toMovieDetail()))
            } catch (e: Exception) {
                emit(Resource.Error(message = e.localizedMessage ?: "Error"))
            }
        }
    }
}