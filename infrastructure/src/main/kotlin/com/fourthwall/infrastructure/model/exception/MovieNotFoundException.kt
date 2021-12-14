package com.fourthwall.infrastructure.model.exception

class MovieNotFoundException(override val message: String = "movie not found"): RuntimeException(message)
