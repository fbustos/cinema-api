plugins {
    id("org.springframework.boot") version "2.6.1" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:2.6.1")
    }
}

dependencies {
    implementation(project(":core"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("org.springframework.retry:spring-retry:1.3.1")
}
