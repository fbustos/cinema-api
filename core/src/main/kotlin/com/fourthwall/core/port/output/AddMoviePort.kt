package com.fourthwall.core.port.output

import com.fourthwall.core.domain.model.Movie
import com.fourthwall.core.port.input.command.AddMovieCommand

interface AddMoviePort {
    fun addMovie(command: AddMovieCommand): Movie
}
