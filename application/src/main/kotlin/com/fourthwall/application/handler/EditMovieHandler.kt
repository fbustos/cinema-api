package com.fourthwall.application.handler

import com.fourthwall.application.model.request.EditMovieRequest
import com.fourthwall.application.model.response.MovieResponse
import com.fourthwall.core.port.input.EditMovieUseCase
import com.fourthwall.core.port.input.command.EditMovieCommand

class EditMovieHandler(private val editMovieUseCase: EditMovieUseCase) {
    operator fun invoke(id: String, request: EditMovieRequest): MovieResponse {
        return MovieResponse.from(
            editMovieUseCase(EditMovieCommand(id, request.rating!!))
        )
    }
}
