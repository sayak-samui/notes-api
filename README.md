# Notes API

A Spring Boot REST API built while learning backend development.

## Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Docker
* Maven

## Features

* Create Software Engineers
* Get All Software Engineers
* Get Software Engineer By ID
* PostgreSQL persistence
* RESTful API endpoints

## Running the Project

### Start PostgreSQL

```bash
docker compose up -d
```

### Run Spring Boot

```bash
./mvnw spring-boot:run
```

or run `Application.java` from IntelliJ.

## API Endpoints

### Get All Engineers

GET `/api/v1/software-engineers`

### Get Engineer By ID

GET `/api/v1/software-engineers/{id}`

### Create Engineer

POST `/api/v1/software-engineers`

Request Body:

```json
{
  "name": "Sayak",
  "techStack": "Java, Spring Boot"
}
```
