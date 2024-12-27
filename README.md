
# Microservice Quiz App

## Overview
The **Microservice Quiz App** is a robust, scalable, and highly available Java-based application designed to offer a quiz service. This application allows users to create quizzes, answer questions, and obtain their quiz results in real-time. Built with modern technologies, this app provides an intuitive and seamless experience for both quiz creators and participants.

## Key Features
- **Quiz Creation**: Users can create custom quizzes by selecting a category, specifying the number of questions, and providing a title.
- **Randomized Questions**: The app supports random selection of quiz questions based on categories.
- **Multiple Choice Questions**: Each quiz contains multiple-choice questions with four possible answers.
- **Real-time Result Calculation**: After completing a quiz, users receive their results, including the number of correct answers and total score.
- **Exception Handling**: Proper error handling for missing resources, invalid inputs, and other edge cases.

## Technologies Used
This application is built using the following technologies:

- **Java 23**: The latest version of Java, ensuring modern features and optimizations.
- **Spring Boot**: A robust framework to create stand-alone, production-grade Spring-based applications with minimal configuration.
- **Spring Data JPA**: Simplifies database interactions and ensures seamless integration with relational databases.

- **PostgreSQL**: A powerful, open-source relational database used to store quiz data, questions, and user responses.
- **Docker**: Containerization platform for creating, deploying, and running applications in isolated environments for consistent performance.
- **Maven**: Build automation tool used for project management, dependencies, and packaging.

## Getting Started

### Prerequisites
- **Java 23** or later
- **Docker** (optional, for containerization)
- **PostgreSQL** (or access to a PostgreSQL database)

### Installation

1. **Clone the repository**:
    ```bash
    https://github.com/TanzimHossain2/Quiz-App.git
    cd Quiz-App
    ```

2. **Build the application**:
   If you're using Maven, run:
    ```bash
    mvn clean install
    ```

3. **Set up PostgreSQL database**:
    - Create a database in PostgreSQL and configure the `application.properties` file with the correct database credentials.

4. **Run the application**:
   If running locally, you can start the application using:
    ```bash
    mvn spring-boot:run
    ```

   Alternatively, you can use Docker to build and run the application in a container:
    ```bash
    docker build -t quiz-app .
    docker run -p 8080:8080 quiz-app
    ```
