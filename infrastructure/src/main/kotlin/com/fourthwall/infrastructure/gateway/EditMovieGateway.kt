package com.fourthwall.infrastructure.gateway

import com.fourthwall.core.domain.model.Movie
import com.fourthwall.core.port.output.EditMoviePort
import com.fourthwall.infrastructure.model.MovieEntity
import com.fourthwall.infrastructure.repository.MovieRepository


class EditMovieGateway(
    private val movieRepository: MovieRepository
) : EditMoviePort {

    override fun editMovie(movie: Movie): Movie {
        return movieRepository.save(MovieEntity.from(movie)).toDomain()
    }
}