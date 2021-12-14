package com.fourthwall.core.domain.model

import java.math.BigDecimal

data class Movie(
    val id: String,
    val imdbId: String,
    val title: String,
    val price: BigDecimal,
    val times: List<MovieTime>,
    val details: MovieDetails? = null
) {
    data class MovieTime(
        val time: String
    )

    data class MovieDetails(
        val description: String,
        val releaseDate: String,
        val imdbRating: String,
        val runtime: String
    )
}
