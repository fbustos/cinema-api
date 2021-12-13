package com.fourthwall.application.model.response

import com.fourthwall.core.domain.model.Movie

data class FindMoviesResponse(val data: List<MovieResponse>) {
    companion object {
        fun from(movies: List<Movie>): FindMoviesResponse {
            return FindMoviesResponse(
                movies.map { MovieResponse.from(it) }
            )
        }
    }
}
