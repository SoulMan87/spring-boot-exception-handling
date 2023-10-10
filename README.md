# Exploring the Power of Spring Boot's @ControllerAdvice and @ExceptionHandler

Welcome to our repository where we delve into the capabilities of Spring Boot's `@ControllerAdvice` and `@ExceptionHandler` through a comprehensive example.

## Overview

In this repository, we demonstrate the usage of Spring Boot's powerful features - `@ControllerAdvice` and `@ExceptionHandler` - to handle exceptions gracefully in a Spring Boot application. These features allow you to centralize your exception handling logic and improve the overall robustness and maintainability of your Spring Boot projects.

## Project Architecture

This project follows a simple layered architecture, showcasing best practices in Spring Boot development:

1. **Controller Layer:** We have organized our API endpoints in a clean and structured manner. The `@RestController` classes handle HTTP requests and responses. Exception handling within these controllers is centralized using `@ControllerAdvice`.

2. **Service Layer:** Business logic is encapsulated in service classes. The service layer is responsible for processing requests and returning data to the controller layer.

3. **Data Layer:** We use an [H2](https://www.h2database.com/html/main.html) database for data storage and retrieval. The `TutorialRepository` manages interactions with the database.

4. **[Swagger UI](https://swagger.io/tools/swagger-ui/):** To facilitate API documentation and testing, we have integrated Swagger UI. You can explore and interact with the API endpoints easily using the Swagger UI interface.

## Getting Started

To get started with this project, follow these steps:

1. Clone the repository:

```bash
   git clone https://github.com/SoulMan87/spring-boot-exception-handling.git
```
2. Build and run the [Spring Boot](https://spring.io/projects/spring-boot) application:

  ```bash
./gradlew bootRun
  ```
3. Access [Swagger UI](https://swagger.io/tools/swagger-ui/):

Open your web browser and navigate to http://localhost:8080/swagger-ui.html. Here, you can explore and test the API endpoints.

# Usage

This project serves as a valuable resource for understanding how to implement centralized exception handling with @ControllerAdvice and @ExceptionHandler in [Spring Boot](https://spring.io/projects/spring-boot). You can refer to the code and examples provided to enhance your own [Spring Boot](https://spring.io/projects/spring-boot) applications.

# Contributions

We welcome contributions from the community. If you have any suggestions, bug fixes, or improvements, please feel free to create issues or submit pull requests. Together, we can make this project even better!

# License

This project is licensed under the [MIT License](https://opensource.org/license/mit/).

