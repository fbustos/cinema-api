package com.fourthwall.core.port.input

import com.fourthwall.core.domain.model.Movie
import com.fourthwall.core.port.input.query.GetMovieQuery

interface GetMovieUseCase {
    operator fun invoke(query: GetMovieQuery): Result<Movie>
}