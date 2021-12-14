package com.fourthwall.core.domain.usecase

import com.fourthwall.core.domain.model.Movie
import com.fourthwall.core.port.input.EditMovieUseCase
import com.fourthwall.core.port.input.command.EditMovieCommand
import com.fourthwall.core.port.input.query.GetMovieQuery
import com.fourthwall.core.port.output.EditMoviePort
import com.fourthwall.core.port.output.GetMoviePort

class EditMovie(
    private val editMoviePort: EditMoviePort,
    private val getMoviePort: GetMoviePort
) : EditMovieUseCase {
    override fun invoke(command: EditMovieCommand): Movie {
        val movie = getMoviePort
            .getMovie(GetMovieQuery(command.id, false))
            .getOrThrow()

        val editedMovie = movie.copy(
            avgRating = calculateRating(movie.avgRating, movie.rateCount, command.rating),
            rateCount = movie.rateCount + 1
        )

        return editMoviePort.editMovie(editedMovie)
    }

    private fun calculateRating(avgRating: Double?, rateCount: Int, rating: Double): Double {
        return ((avgRating ?: 0.0) * rateCount + rating) / (rateCount + 1)
    }
}