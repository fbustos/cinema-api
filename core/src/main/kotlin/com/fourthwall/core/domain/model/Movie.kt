package com.fourthwall.core.domain.model

import java.math.BigDecimal

data class Movie(
    val id: String,
    val imdbId: String,
    val title: String,
    val price: BigDecimal,
    val times: List<MovieTime>,
    val avgRating: Double? = null,
    val rateCount: Int = 0,
    val details: MovieDetails? = null
) {
    data class MovieTime(
        val id: String,
        val time: String
    )

    data class MovieDetails(
        val description: String,
        val releaseDate: String,
        val imdbRating: String,
        val runtime: String
    )
}
