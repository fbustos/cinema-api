package com.fourthwall.application.controller

import com.fourthwall.application.handler.AddMovieHandler
import com.fourthwall.application.handler.FindMoviesHandler
import com.fourthwall.application.handler.GetMovieHandler
import com.fourthwall.application.model.request.AddMovieRequest
import com.fourthwall.application.model.response.MoviesResponse
import com.fourthwall.application.model.response.MovieResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/movies")
class MovieController(
    private val findMoviesHandler: FindMoviesHandler,
    private val addMovieHandler: AddMovieHandler,
    private val getMovieHandler: GetMovieHandler,
    ) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findMovies(@RequestParam movies: List<String>?): MoviesResponse {
        return findMoviesHandler(movies)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addMovie(@Valid @RequestBody movie: AddMovieRequest): MovieResponse {
        return addMovieHandler(movie)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getMovie(@PathVariable id: String, @RequestParam(defaultValue = "true") details: Boolean = true): MovieResponse {
        return getMovieHandler(id, details).getOrThrow()
    }
}