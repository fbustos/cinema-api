package com.fourthwall.application.model.response

data class ApiError(
    val code: String,
    val message: String? = "An error has occurred"
)
