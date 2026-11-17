# EmployeePayrollApp

## About the Project

The **Employee Payroll App** is a Spring Boot-based backend application developed to manage employee payroll information.

The application provides REST APIs to perform employee operations such as creating, retrieving, updating, and deleting employee records.

It uses Spring Boot to handle REST requests, Spring Data JPA to interact with the database, and MySQL to store employee information.

The project is developed step by step using different use cases, starting from basic REST API development and progressing towards database integration.

## Objectives

- Develop a backend application using Spring Boot.
- Handle HTTP requests using REST Controllers.
- Transfer employee information using DTOs.
- Separate application logic using the Service Layer.
- Implement CRUD operations.
- Store employee payroll information in MySQL.
- Test application functionality using JUnit and CURL.

## Technologies Used

| Technology | Purpose |
|---|---|
| Java 21 | Programming language |
| Spring Boot | Backend framework |
| Spring Web MVC | REST API development |
| Spring Data JPA | Database operations |
| Hibernate | Object-relational mapping |
| MySQL | Database |
| Maven | Dependency management and build |
| JUnit 5 | Unit testing |
| Mockito | Mock-based testing |
| Git & GitHub | Version control |

## Features

- REST API development.
- Employee creation and retrieval.
- Employee information updates.
- Employee deletion.
- DTO and Model implementation.
- Service Layer architecture.
- Constructor-based Dependency Injection.
- In-memory employee data management.
- MySQL database integration.
- JUnit and Mockito testing.

## Project Structure

```text
EmployeePayrollApp/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/employeepayrollapp/
│   │   │       │
│   │   │       ├── controller/
│   │   │       │   └── EmployeePayrollController.java
│   │   │       │
│   │   │       ├── dto/
│   │   │       │   └── EmployeeDTO.java
│   │   │       │
│   │   │       ├── model/
│   │   │       │   └── EmployeePayrollData.java
│   │   │       │
│   │   │       ├── repository/
│   │   │       │   └── EmployeePayrollRepository.java
│   │   │       │
│   │   │       ├── service/
│   │   │       │   └── EmployeePayrollService.java
│   │   │       │
│   │   │       └── EmployeePayrollAppApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── java/
│           └── com/example/employeepayrollapp/
│               │
│               ├── controller/
│               │   └── EmployeePayrollControllerTest.java
│               │
│               ├── dto/
│               │   └── EmployeeDTOTest.java
│               │
│               ├── model/
│               │   └── EmployeePayrollDataTest.java
│               │
│               ├── service/
│               │   └── EmployeePayrollServiceTest.java
│               │
│               └── EmployeePayrollAppApplicationTests.java
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## Application Architecture

The application follows a layered architecture:

1. **Controller Layer:** Handles incoming HTTP requests and sends responses.
2. **DTO Layer:** Transfers employee information between the client and application.
3. **Model Layer:** Represents employee payroll data.
4. **Service Layer:** Contains business logic and manages employee operations.
5. **Repository Layer:** Communicates with the MySQL database using Spring Data JPA.

## Use Cases Implemented

| Use Case | Description |
|---|---|
| UC1 | Spring Boot project setup and REST connectivity |
| UC2 | REST Controller and HTTP methods |
| UC3 | Introduction of DTO and Model |
| UC4 | Introduction of Service Layer and Dependency Injection |
| UC5 | Employee data management using an in-memory List |
| UC4 Enhancement | MySQL database integration using Spring Data JPA |

*Note: The UC4 Enhancement is the database persistence stage added to this project's Git workflow. The original assignment slides repeat some UC labels.*

## Database Configuration

The application uses MySQL.

Create the database:

```sql
CREATE DATABASE payroll_service;
```

Configure the database connection in `application.properties`:

```properties
server.port=8083

spring.datasource.url=jdbc:mysql://localhost:3306/payroll_service
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.open-in-view=false
```

Set the `DB_PASSWORD` environment variable before running the application.

## How to Run the Project

**1. Clone the repository**

```bash
git clone <your-github-repository-url>
```

**2. Navigate to the project directory**

```bash
cd EmployeePayrollApp
```

**3. Run the application**

```bash
.\mvnw.cmd spring-boot:run
```

The application runs on:

`http://localhost:8083`

## REST API Endpoints

Base URL:

`http://localhost:8083/employeepayrollservice`

| HTTP Method | Endpoint | Operation |
|---|---|---|
| GET | `/` | Welcome message |
| GET | `/get` | Get all employees |
| GET | `/get/{id}` | Get employee by ID |
| POST | `/create` | Create employee |
| PUT | `/update/{id}` | Update employee |
| DELETE | `/delete/{id}` | Delete employee |

## Testing

Run all unit tests using Maven:

```bash
.\mvnw.cmd clean test
```

REST APIs can also be tested using CURL commands.

## Version Control

The project follows a Git branching workflow:

- `main` – Main project overview and README.
- `develop` – Integrated development code.
- `feature/UC1-ProjectSetup` – Project setup.
- `feature/UC2-RestController` – REST Controller implementation.
- `feature/UC3-ServiceLayer` – Service Layer and employee management.
- `feature/UC4-MySQLPersistence` – MySQL database integration.

Feature branches are maintained separately and merged into the `develop` branch after implementation.

## Future Enhancements

- Employee input validation.
- Improved exception handling.
- Additional payroll-related employee details.
- Integration with the Employee Payroll frontend.
- Additional automated tests.

---

**Project:** Employee Payroll App  
**Language:** Java  
**Framework:** Spring Boot  
**Database:** MySQL
