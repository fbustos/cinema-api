package com.fourthwall.application.model.request

import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class AddMovieRequest(
    @field:NotNull
    @field:NotBlank
    val imdbId: String?,

    @field:NotNull
    @field:NotBlank
    val title: String?,

    @field:NotNull
    val price: BigDecimal?,

    val times: List<String>?
)
