package com.fourthwall.application

import org.slf4j.LoggerFactory
import org.springframework.http.HttpRequest
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse
import org.springframework.stereotype.Component
import org.springframework.util.StreamUtils
import java.nio.charset.Charset

@Component
class LoggingInterceptor : ClientHttpRequestInterceptor {

    private val log = LoggerFactory.getLogger(LoggingInterceptor::class.java)

    override fun intercept(
        request: HttpRequest,
        body: ByteArray,
        execution: ClientHttpRequestExecution
    ): ClientHttpResponse {
        logRequest(request, body)
        val response = execution.execute(request, body)
        logResponse(response)

        return response
    }

    private fun logRequest(request: HttpRequest, body: ByteArray) {
        if (log.isDebugEnabled) {
            log.debug("===log request start===")
            log.debug("URI: {}", request.uri)
            log.debug("Method: {}", request.method)
            log.debug("Headers: {}", request.headers)
            log.debug("Request body: {}", String(body, Charset.forName("UTF-8")))
            log.debug("===log request end===")
        }
    }

    private fun logResponse(response: ClientHttpResponse) {
        if (log.isDebugEnabled) {
            log.debug("===log response start===")
            log.debug("Status code: {}", response.statusCode)
            log.debug("Status text: {}", response.statusText)
            log.debug("Headers: {}", response.headers)
            log.debug("Response body: {}", StreamUtils.copyToString(response.body, Charset.defaultCharset()))
            log.debug("===log response end===")
        }
    }
}