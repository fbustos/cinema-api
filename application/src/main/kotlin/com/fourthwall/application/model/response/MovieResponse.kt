package com.fourthwall.application.model.response

import com.fourthwall.core.domain.model.Movie
import java.math.BigDecimal

data class MovieResponse(
    val id: String,
    val imdbId: String,
    val title: String,
    val price: BigDecimal,
    val times: List<String>,
    val details: MovieDetailsResponse? = null
) {
    data class MovieDetailsResponse(
        val description: String,
        val releaseDate: String,
        val imdbRating: String,
        val runtime: String
    ) {
        companion object {
            fun from(details: Movie.MovieDetails): MovieDetailsResponse {
                return MovieDetailsResponse(
                    details.description,
                    details.releaseDate,
                    details.imdbRating,
                    details.runtime
                )
            }
        }
    }

    companion object {
        fun from(movie: Movie): MovieResponse {
            return MovieResponse(
                movie.id,
                movie.imdbId,
                movie.title,
                movie.price,
                movie.times.map { it.time },
                movie.details?.let { MovieDetailsResponse.from(it) }
            )
        }
    }
}
