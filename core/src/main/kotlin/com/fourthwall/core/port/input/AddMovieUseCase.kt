package com.fourthwall.core.port.input

import com.fourthwall.core.domain.model.Movie
import com.fourthwall.core.port.input.command.AddMovieCommand
import com.fourthwall.core.port.input.query.FindMoviesQuery

interface AddMovieUseCase {
    operator fun invoke(command: AddMovieCommand): Movie
}