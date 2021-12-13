package com.fourthwall.application.controller

import com.fourthwall.application.handler.AddMovieHandler
import com.fourthwall.application.handler.FindMoviesHandler
import com.fourthwall.application.model.request.AddMovieRequest
import com.fourthwall.application.model.response.FindMoviesResponse
import com.fourthwall.application.model.response.MovieResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/movies")
class MovieController(
    private val findMoviesHandler: FindMoviesHandler,
    private val addMovieHandler: AddMovieHandler,
    ) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findMovies(@RequestParam movies: List<String>?): FindMoviesResponse {
        return findMoviesHandler(movies)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addMovie(@Valid @RequestBody movie: AddMovieRequest): MovieResponse {
        return addMovieHandler(movie)
    }
}