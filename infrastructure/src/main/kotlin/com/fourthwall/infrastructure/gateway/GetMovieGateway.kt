package com.fourthwall.infrastructure.gateway

import com.fourthwall.core.domain.model.Movie
import com.fourthwall.core.port.input.query.GetMovieQuery
import com.fourthwall.core.port.output.GetMoviePort
import com.fourthwall.infrastructure.client.OmdbClient
import com.fourthwall.infrastructure.model.exception.MovieNotFoundException
import com.fourthwall.infrastructure.repository.MovieRepository
import java.util.*

class GetMovieGateway(
    private val movieRepository: MovieRepository,
    private val omdbClient: OmdbClient
) : GetMoviePort {
    override fun getMovie(query: GetMovieQuery): Result<Movie> {
        return runCatching {
            val movie = movieRepository
                .findById(UUID.fromString(query.movieId))
                .orElseThrow { throw MovieNotFoundException() }
                .toDomain()

            if (query.details)
                movie.copy(details = omdbClient.getMovie(movie.imdbId).toDomain())
            else
                movie
        }
    }

}