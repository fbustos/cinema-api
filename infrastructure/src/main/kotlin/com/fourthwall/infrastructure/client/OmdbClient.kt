package com.fourthwall.infrastructure.client

import com.fourthwall.infrastructure.client.dto.OmdbMovie
import org.slf4j.LoggerFactory
import org.springframework.retry.support.RetryTemplate
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import java.util.concurrent.TimeoutException

class OmdbClient(
    private val restTemplate: RestTemplate,
    private val retryTemplate: RetryTemplate,
    private val apiKey: String
) {
    private val log = LoggerFactory.getLogger(OmdbClient::class.java)

    fun getMovie(imdbId: String): OmdbMovie {
        return retryTemplate.execute<OmdbMovie, TimeoutException> {
            log.info("fetching data from omdb client")
            restTemplate.getForObject(
                URL, mapOf(
                    "apikey" to apiKey,
                    "imdbId" to imdbId
                )
            )
        }
    }

    companion object {
        const val URL = "https://www.omdbapi.com?apikey={apikey}&i={imdbId}"
    }
}

