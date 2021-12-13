package com.fourthwall.core.port.input.command

import java.math.BigDecimal

data class AddMovieCommand(
    val imdbId: String,
    val title: String,
    val price: BigDecimal,
    val times: List<String>?
)
