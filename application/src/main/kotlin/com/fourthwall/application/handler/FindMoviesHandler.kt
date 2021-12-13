package com.fourthwall.application.handler

import com.fourthwall.application.model.response.FindMoviesResponse
import com.fourthwall.core.port.input.FindMoviesUseCase
import com.fourthwall.core.port.input.query.FindMoviesQuery

class FindMoviesHandler(private val findMoviesUseCase: FindMoviesUseCase) {

    operator fun invoke(movies: List<String>?): FindMoviesResponse {
        return FindMoviesResponse.from(findMoviesUseCase(FindMoviesQuery(movies)))
    }
}
