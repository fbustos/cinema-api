package com.fourthwall.core.port.output

import com.fourthwall.core.domain.model.Movie
import com.fourthwall.core.port.input.query.GetMovieQuery

interface GetMoviePort {
    fun getMovie(query: GetMovieQuery): Result<Movie>
}
