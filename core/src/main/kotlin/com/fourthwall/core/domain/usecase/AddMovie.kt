package com.fourthwall.core.domain.usecase

import com.fourthwall.core.domain.model.Movie
import com.fourthwall.core.port.input.AddMovieUseCase
import com.fourthwall.core.port.input.command.AddMovieCommand
import com.fourthwall.core.port.output.AddMoviePort

class AddMovie(private val addMoviePort: AddMoviePort): AddMovieUseCase {

    override fun invoke(command: AddMovieCommand): Movie {
        return addMoviePort.addMovie(command)
    }
}