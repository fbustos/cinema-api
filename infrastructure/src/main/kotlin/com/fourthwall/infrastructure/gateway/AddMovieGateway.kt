package com.fourthwall.infrastructure.gateway

import com.fourthwall.core.domain.model.Movie
import com.fourthwall.core.port.input.command.AddMovieCommand
import com.fourthwall.core.port.output.AddMoviePort
import com.fourthwall.infrastructure.model.MovieEntity
import com.fourthwall.infrastructure.model.MovieTimeEntity
import com.fourthwall.infrastructure.repository.MovieRepository


class AddMovieGateway(
    private val movieRepository: MovieRepository
) : AddMoviePort {

    override fun addMovie(command: AddMovieCommand): Movie {
        with(command) {
            return movieRepository.save(
                MovieEntity(
                    imdbId = imdbId,
                    title = title,
                    price = price,
                    times = times?.map { MovieTimeEntity(time = it) })
            ).toDomain()
        }
    }
}