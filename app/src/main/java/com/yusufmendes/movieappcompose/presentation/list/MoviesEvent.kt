package com.yusufmendes.movieappcompose.presentation.list

sealed class MoviesEvent {
    data class Search(val searchString: String) : MoviesEvent()
}
