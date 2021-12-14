package com.fourthwall.application.model.request

import javax.validation.constraints.NotNull

data class EditMovieRequest(
    @NotNull
    val rating: Double?
)
