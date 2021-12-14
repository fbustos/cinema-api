package com.fourthwall.application.model.response

import com.fourthwall.core.domain.model.Movie

data class MoviesResponse(val data: List<MovieResponse>) {
    companion object {
        fun from(movies: List<Movie>): MoviesResponse {
            return MoviesResponse(
                movies.map { MovieResponse.from(it) }
            )
        }
    }
}
