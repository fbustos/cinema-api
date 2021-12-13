package com.fourthwall.infrastructure.gateway

import com.fourthwall.core.domain.model.Movie
import com.fourthwall.core.port.input.query.FindMoviesQuery
import com.fourthwall.core.port.output.FindMoviesPort
import com.fourthwall.infrastructure.repository.MovieRepository


class FindMoviesGateway(
    private val movieRepository: MovieRepository
): FindMoviesPort{

    override fun findMovies(query: FindMoviesQuery): List<Movie> {
        return movieRepository.findAll()
            .filter { query.moviesIds?.contains(it.id.toString()) ?: true }
            .map { it.toDomain() }
    }
}