package com.fourthwall.core.domain.model

import java.math.BigDecimal

data class Movie(
    val id: String,
    val imdbId: String,
    val title: String,
    val price: BigDecimal,
    val times: List<MovieTime>
) {
    data class MovieTime(
        val time: String
    )
}
