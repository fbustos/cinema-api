package com.fourthwall.application.model.request

import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class AddMovieRequest(
    @NotNull
    @NotBlank
    val imdbId: String?,

    @NotNull
    @NotBlank
    val title: String?,

    @NotNull
    val price: BigDecimal?,

    val times: List<String>?
)
