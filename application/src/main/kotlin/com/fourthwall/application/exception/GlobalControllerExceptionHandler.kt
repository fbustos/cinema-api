package com.fourthwall.application.exception

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fourthwall.application.model.response.ApiError
import com.fourthwall.infrastructure.model.exception.MovieNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.support.WebExchangeBindException
import org.springframework.web.client.RestClientResponseException
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class GlobalControllerExceptionHandler : ResponseEntityExceptionHandler() {

    private val log = LoggerFactory.getLogger(GlobalControllerExceptionHandler::class.java)

    @ExceptionHandler(MovieNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleMovieNotFound(ex: RuntimeException): ResponseEntity<ApiError> {
        val apiError = ApiError(HttpStatus.NOT_FOUND.name, ex.message)
        return ResponseEntity(apiError, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(RestClientResponseException::class)
    fun handleRestClientResponseException(ex: RestClientResponseException): ResponseEntity<ApiError> {
        log.error(
            "Error from RestTemplate - Status \"${ex.rawStatusCode}\", Body \"${ex.responseBodyAsString}\"",
            ex
        )
        return ResponseEntity(createApiError(ex), HttpStatus.valueOf(ex.rawStatusCode))
    }

    @ExceptionHandler(WebExchangeBindException::class)
    fun handleWebExchangeBindException(ex: WebExchangeBindException): ResponseEntity<ApiError> {
        with(ex) {
            val message = "${fieldError?.field} has invalid value '${fieldError?.rejectedValue}'"
            val apiError = ApiError(status.name, message)
            return ResponseEntity(apiError, status)
        }
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(ex: Exception): ResponseEntity<ApiError> {
        val status = HttpStatus.INTERNAL_SERVER_ERROR
        val apiError = ApiError(status.name, ex.message)
        log.error("Error - Message \"${ex.message}\", Cause \"${ex.cause}\"", ex)
        return ResponseEntity(apiError, status)
    }

    private fun createApiError(ex: RestClientResponseException): ApiError {
        return try {
            val error = jacksonObjectMapper().readValue(ex.responseBodyAsString, ApiError::class.java)
            ApiError(error.code, error.message)
        } catch (e: Exception) {
            ApiError(ex.statusText, ex.message)
        }
    }
}