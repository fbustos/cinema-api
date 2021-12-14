package com.fourthwall.application.configuration

import com.fourthwall.application.LoggingInterceptor
import com.fourthwall.application.handler.AddMovieHandler
import com.fourthwall.application.handler.FindMoviesHandler
import com.fourthwall.application.handler.GetMovieHandler
import com.fourthwall.core.domain.usecase.AddMovie
import com.fourthwall.core.domain.usecase.FindMovies
import com.fourthwall.core.domain.usecase.GetMovie
import com.fourthwall.core.port.input.AddMovieUseCase
import com.fourthwall.core.port.input.FindMoviesUseCase
import com.fourthwall.core.port.input.GetMovieUseCase
import com.fourthwall.core.port.output.AddMoviePort
import com.fourthwall.core.port.output.FindMoviesPort
import com.fourthwall.core.port.output.GetMoviePort
import com.fourthwall.infrastructure.client.OmdbClient
import com.fourthwall.infrastructure.gateway.AddMovieGateway
import com.fourthwall.infrastructure.gateway.FindMoviesGateway
import com.fourthwall.infrastructure.gateway.GetMovieGateway
import com.fourthwall.infrastructure.repository.MovieRepository
import org.eclipse.jetty.http.HttpHeader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.http.MediaType
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate
import java.util.*


@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = ["com.fourthwall"])
@ComponentScan(basePackages = ["com.fourthwall"])
@EntityScan(basePackages = ["com.fourthwall"])
open class MovieConfiguration(
    @Autowired private val movieRepository: MovieRepository
) {

    /// Find Movies
    @Bean
    open fun findMoviesHandler(findMoviesUseCase: FindMoviesUseCase): FindMoviesHandler {
        return FindMoviesHandler(findMoviesUseCase)
    }

    @Bean
    open fun findMoviesUseCase(findMoviesPort: FindMoviesPort): FindMoviesUseCase {
        return FindMovies(findMoviesPort)
    }

    @Bean
    open fun findMoviesPort(): FindMoviesPort {
        return FindMoviesGateway(movieRepository)
    }

    /// Add Movie
    @Bean
    open fun addMovieHandler(addMovieUseCase: AddMovieUseCase): AddMovieHandler {
        return AddMovieHandler(addMovieUseCase)
    }

    @Bean
    open fun addMovieUseCase(addMoviePort: AddMoviePort): AddMovieUseCase {
        return AddMovie(addMoviePort)
    }

    @Bean
    open fun addMoviePort(): AddMoviePort {
        return AddMovieGateway(movieRepository)
    }

    /// Get Movie
    @Bean
    open fun getMovieHandler(getMovieUseCase: GetMovieUseCase): GetMovieHandler {
        return GetMovieHandler(getMovieUseCase)
    }

    @Bean
    open fun getMovieUseCase(getMoviePort: GetMoviePort): GetMovieUseCase {
        return GetMovie(getMoviePort)
    }

    @Bean
    open fun getMoviePort(omdbClient: OmdbClient): GetMoviePort {
        return GetMovieGateway(movieRepository, omdbClient)
    }

    @Bean
    open fun omdbClient(restTemplate: RestTemplate): OmdbClient {
        return OmdbClient(restTemplate, System.getenv("apiKey"))
    }

    @Bean
    open fun restTemplate(loggingInterceptor: LoggingInterceptor): RestTemplate {
        return RestTemplateBuilder()
            .interceptors(loggingInterceptor)
            .defaultHeader("Content-Type", "application/json;charset=UTF-8")
            .build()
    }
}