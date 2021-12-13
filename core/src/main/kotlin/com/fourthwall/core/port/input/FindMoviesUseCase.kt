package com.fourthwall.core.port.input

import com.fourthwall.core.domain.model.Movie
import com.fourthwall.core.port.input.query.FindMoviesQuery

interface FindMoviesUseCase {
    operator fun invoke(query: FindMoviesQuery): List<Movie>
}