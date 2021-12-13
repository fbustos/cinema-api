package com.fourthwall.application.model.response

import com.fourthwall.core.domain.model.Movie
import java.math.BigDecimal

data class MovieResponse(
    val id: String,
    val imdbId: String,
    val title: String,
    val price: BigDecimal,
    val times: List<String>
) {
    companion object {
        fun from(movie: Movie): MovieResponse {
            return MovieResponse(
                movie.id,
                movie.imdbId,
                movie.title,
                movie.price,
                movie.times.map { it.time }
            )
        }
    }
}
