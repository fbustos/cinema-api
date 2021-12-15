package com.fourthwall.application.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
open class SecurityConfiguration : WebSecurityConfigurerAdapter() {

    @Bean
    open fun encoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        val pass = System.getenv("adminPass")
        auth.inMemoryAuthentication()
            .withUser(USER)
            .password(encoder().encode(pass))
            .roles(ROLE_ADMIN)
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/movies").hasRole(ROLE_ADMIN)
            .antMatchers(HttpMethod.GET).permitAll()
            .and()
            .csrf().disable()
            .formLogin().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }

    companion object {
        private const val USER = "admin"
        private const val ROLE_ADMIN = "ADMIN"
    }
}