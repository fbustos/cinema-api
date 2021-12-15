# CINEMA API
API for cinema challenge

## Setup
Declare secrets as environment variables
```aidl
export apiKey=*****
export adminPass=*****
```
This secrets will be provided by the developer.

## Running app
In terminal run
```aidl
./gradlew build \
docker-compose up --build
```

## Endpoints
 - POST http://localhost:8080/movies
```
Creates a movie. This endpoint is protected because is admin only. You need to provide basic authentication for store a movie
```
 - GET http://localhost:8080/movies
```
Fetch movies from local DB. It can be filtered by :moviesIds. Allows to client see movie times
```
 - GET http://localhost:8080/movies/{movieId}
```
Find movie details. Fetch from OMDB service the movie details depending on :details queryparam. By detault is true
```
 - PATCH http://localhost:8080/movies/{movieId}
```
Edit movie, specifically made to rate the movie.
```
- PATCH http://localhost:8080/docs.html
```
Swagger documentation
```
- PATCH http://localhost:8080/actuator/metrics
```
Api metrics
```

## Design Decisions
- The relationship between movie and time is in another table, allowing in the future store more information about that relationship
- Postgres is used as database engine, because I can't see this model changing frequently.
- Springboot is chosen as framework because it gives me resolved microservice features for this challenge purpose.
- Hexagonal Architecture is implemented because is easy to extend for coworkers.

## What goes where?

- <strong>Core</strong>
  The center of the hexagon. It is the one that contains the business logic and domain model. It does not contain references to transport problems such as JSON, specific persistence technologies, or time references.

- <strong>Infrastructure</strong>
  Everything that exists outside the hexagon. Nothing related to business logic. It contains things like JSON transformers, REST end-points, messaging handler, event publisher, database repositories, scheduled events, and more.

- <strong>Application</strong>
  The Application module is the one unites everything and configures the framework to be used to run the service.