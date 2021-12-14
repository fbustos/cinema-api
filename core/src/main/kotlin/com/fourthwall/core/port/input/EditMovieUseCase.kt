package com.fourthwall.core.port.input

import com.fourthwall.core.domain.model.Movie
import com.fourthwall.core.port.input.command.EditMovieCommand

interface EditMovieUseCase {
    operator fun invoke(command: EditMovieCommand): Movie
}
