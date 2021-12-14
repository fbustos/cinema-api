package com.fourthwall.core.port.output

import com.fourthwall.core.domain.model.Movie

interface EditMoviePort {
    fun editMovie(movie: Movie): Movie
}
