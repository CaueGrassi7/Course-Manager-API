# Course-Manager-API

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)

## Overview

**Course-Manager-API** is a RESTful API built using Java Spring Boot for managing courses in a programming education system. It supports standard CRUD operations on course data, allowing you to create, retrieve, update, and delete course information.

## Features

- **Create Courses**: Add new courses with details like name, category, and description.
- **Retrieve Courses**: Get a list of all courses or details of a specific course by ID.
- **Update Courses**: Modify existing course information.
- **Delete Courses**: Remove courses from the system.

## Technologies Used

- Java 17
- Spring Boot 3.3.2
- Spring Data JPA
- H2 Database
- Maven
- Lombok

## Installation

### Requirements

- Java 17+
- Maven

### Installation Steps

1. Clone the repository:
    ```sh
    git clone https://github.com/CaueGrassi7/Course-Manager-API.git
    ```
2. Navigate to the project directory:
    ```sh
    cd Course-Manager-API
    ```
3. Build the project using Maven:
    ```sh
    mvn clean install
    ```
4. Run the application:
    ```sh
    mvn spring-boot:run
    ```

The application will start on `http://localhost:8080`.

## API Endpoints

### Create a New Course

- **URL:** `/courses`
- **Method:** `POST`
- **Request Body:**
    ```json
    {
        "name": "Java Programming",
        "category": "Programming",
        "description": "Learn Java from basics to advanced",
        "active": true
    }
    ```
- **Response:** `201 Created`

### Retrieve All Courses

- **URL:** `/courses`
- **Method:** `GET`
- **Response:**
    ```json
    [
        {
            "id": 1,
            "name": "Java Programming",
            "category": "Programming",
            "description": "Learn Java from basics to advanced",
            "active": true,
            "createdAt": "2024-08-19T10:00:00",
            "updatedAt": "2024-08-19T10:00:00"
        }
    ]
    ```

### Retrieve a Specific Course

- **URL:** `/courses/{id}`
- **Method:** `GET`
- **Response:**
    ```json
    {
        "id": 1,
        "name": "Java Programming",
        "category": "Programming",
        "description": "Learn Java from basics to advanced",
        "active": true,
        "createdAt": "2024-08-19T10:00:00",
        "updatedAt": "2024-08-19T10:00:00"
    }
    ```

### Update a Course

- **URL:** `/courses/{id}`
- **Method:** `PUT`
- **Request Body:**
    ```json
    {
        "name": "Advanced Java Programming",
        "category": "Programming",
        "description": "Advanced concepts of Java programming",
        "active": true
    }
    ```
- **Response:** `200 OK`

### Delete a Course

- **URL:** `/courses/{id}`
- **Method:** `DELETE`
- **Response:** `204 No Content`

## Contributing

Contributions are welcome! Follow the steps below to contribute:

1. Fork the project.
2. Create a branch for your feature or bugfix (`git checkout -b feature/new-feature`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature/new-feature`).
5. Open a Pull Request.
