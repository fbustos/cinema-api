package com.fourthwall.application.handler

import com.fourthwall.application.model.response.MovieResponse
import com.fourthwall.core.port.input.GetMovieUseCase
import com.fourthwall.core.port.input.query.GetMovieQuery

class GetMovieHandler(private val getMovieUseCase: GetMovieUseCase) {

    operator fun invoke(movieId: String, details: Boolean): Result<MovieResponse> {
        return getMovieUseCase(GetMovieQuery(movieId, details)).map { MovieResponse.from(it) }
    }
}
