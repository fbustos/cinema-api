package com.fourthwall.core.domain.usecase

import com.fourthwall.core.domain.model.Movie
import com.fourthwall.core.port.input.FindMoviesUseCase
import com.fourthwall.core.port.input.query.FindMoviesQuery
import com.fourthwall.core.port.output.FindMoviesPort

class FindMovies(private val findMoviesPort: FindMoviesPort): FindMoviesUseCase {
    override fun invoke(query: FindMoviesQuery): List<Movie> {
        return findMoviesPort.findMovies(query)
    }
}