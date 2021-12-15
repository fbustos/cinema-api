application {
    mainClass.set("com.fourthwall.application.AppKt")
}

plugins {
    application
    id("org.springframework.boot") version "2.6.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

dependencies {
    implementation(project(":core"))
    implementation(project(":infrastructure"))

    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web") {
        exclude("org.springframework.boot:spring-boot-starter-tomcat")
    }
    implementation("org.springframework.boot:spring-boot-starter-jetty")
    implementation("org.springframework.retry:spring-retry:1.3.1")
    implementation("io.micrometer:micrometer-registry-prometheus")

    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    compileOnly("org.springdoc:springdoc-openapi-ui:1.5.13")
    compileOnly("org.springdoc:springdoc-openapi-kotlin:1.5.13")
}
