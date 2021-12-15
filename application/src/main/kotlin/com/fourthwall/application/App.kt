package com.fourthwall.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.fourthwall"])
@EnableConfigurationProperties
@ConfigurationPropertiesScan
open class App

fun main(args: Array<String>) {
    runApplication<App>(*args)
}