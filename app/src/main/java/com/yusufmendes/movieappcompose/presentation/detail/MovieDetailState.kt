package com.yusufmendes.movieappcompose.presentation.detail

import com.yusufmendes.movieappcompose.domain.model.MovieDetail

data class MovieDetailState(
    val isLoading: Boolean = false,
    val movie: MovieDetail? = null,
    val error: String = ""
)
