package com.yusufmendes.movieappcompose.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.yusufmendes.movieappcompose.domain.model.Movie

data class MoviesDto(
    @SerializedName("Response")
    val response: String,
    @SerializedName("Search")
    val search: List<Search>,
    val totalResults: String
)

fun MoviesDto.toMovieList(): List<Movie> {
    //map->bir objeyi başka bir objeye transform etmek için kullanılır
    return search.map { search ->
        Movie(search.poster, search.title, search.year, search.imdbID)
    }
}