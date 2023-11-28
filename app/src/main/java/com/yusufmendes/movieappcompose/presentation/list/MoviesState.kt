package com.yusufmendes.movieappcompose.presentation.list

import com.yusufmendes.movieappcompose.domain.model.Movie

data class MoviesState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = "",
    val search: String = "Batman"
)
