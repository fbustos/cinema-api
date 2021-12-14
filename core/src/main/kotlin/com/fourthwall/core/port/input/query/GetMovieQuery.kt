package com.fourthwall.core.port.input.query

data class GetMovieQuery(
    val movieId: String,
    val details: Boolean
)
