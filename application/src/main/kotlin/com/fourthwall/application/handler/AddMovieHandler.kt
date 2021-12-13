package com.fourthwall.application.handler

import com.fourthwall.application.model.request.AddMovieRequest
import com.fourthwall.application.model.response.MovieResponse
import com.fourthwall.core.port.input.AddMovieUseCase
import com.fourthwall.core.port.input.command.AddMovieCommand

data class AddMovieHandler(
    private val addMovieUseCase: AddMovieUseCase
) {
    operator fun invoke(movie: AddMovieRequest): MovieResponse {
        with(movie) {
            return MovieResponse.from(
                addMovieUseCase(AddMovieCommand(imdbId!!, title!!, price!!, times))
            )
        }
    }
}
