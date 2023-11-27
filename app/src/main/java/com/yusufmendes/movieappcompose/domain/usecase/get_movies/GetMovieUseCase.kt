package com.yusufmendes.movieappcompose.domain.usecase.get_movies

import com.yusufmendes.movieappcompose.data.remote.dto.toMovieList
import com.yusufmendes.movieappcompose.domain.model.Movie
import com.yusufmendes.movieappcompose.domain.repository.MovieRepository
import com.yusufmendes.movieappcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    fun executeGetMovies(search: String): Flow<Resource<List<Movie>>> {
        return flow {
            try {
                emit(Resource.Loading())
                val movieList = movieRepository.getMovies(search)
                if (movieList.response.equals("True")) {
                    emit(Resource.Success(movieList.toMovieList()))
                } else {
                    emit(Resource.Error(message = "No movie found!"))
                }
            } catch (e: Exception) {
                emit(Resource.Error(message = e.localizedMessage ?: "Error"))
            }
        }
    }
}