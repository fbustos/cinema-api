package com.fourthwall.infrastructure.client

import com.fourthwall.infrastructure.client.dto.OmdbMovie
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

class OmdbClient(
    private val restTemplate: RestTemplate,
    private val apiKey: String
) {
    fun getMovie(imdbId: String): OmdbMovie {
        return restTemplate.getForObject(
            URL, mapOf(
                "apikey" to apiKey,
                "imdbId" to imdbId
            )
        )
    }

    companion object {
        const val URL = "https://www.omdbapi.com?apikey={apikey}&i={imdbId}"
    }
}

