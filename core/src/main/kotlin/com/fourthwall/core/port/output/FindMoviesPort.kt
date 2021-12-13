package com.fourthwall.core.port.output

import com.fourthwall.core.domain.model.Movie
import com.fourthwall.core.port.input.query.FindMoviesQuery

interface FindMoviesPort {
    fun findMovies(query: FindMoviesQuery): List<Movie>
}
