package com.fourthwall.core.domain.usecase

import com.fourthwall.core.domain.model.Movie
import com.fourthwall.core.port.input.GetMovieUseCase
import com.fourthwall.core.port.input.query.GetMovieQuery
import com.fourthwall.core.port.output.GetMoviePort

class GetMovie(private val getMoviePort: GetMoviePort): GetMovieUseCase {
    override fun invoke(query: GetMovieQuery): Result<Movie> {
        return getMoviePort.getMovie(query)
    }
}