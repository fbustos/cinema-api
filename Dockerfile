FROM openjdk:17-alpine
MAINTAINER franco-bustos
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=application/build/libs/application-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} cinema-api.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/cinema-api.jar"]