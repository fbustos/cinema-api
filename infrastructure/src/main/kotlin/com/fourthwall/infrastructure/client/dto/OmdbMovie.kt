package com.fourthwall.infrastructure.client.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fourthwall.core.domain.model.Movie

@JsonIgnoreProperties(ignoreUnknown = true)
data class OmdbMovie(
    @JsonProperty("Released") val released: String,
    @JsonProperty("Runtime") val runtime: String,
    @JsonProperty("Plot") val plot: String,
    val imdbRating: String,
    val imdbID: String,
) {
    fun toDomain(): Movie.MovieDetails {
        return Movie.MovieDetails(
            plot,
            released,
            imdbRating,
            runtime
        )
    }
}