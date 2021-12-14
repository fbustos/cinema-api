package com.fourthwall.infrastructure.model

class MovieNotFoundException(override val message: String = "movie not found"): RuntimeException(message)
