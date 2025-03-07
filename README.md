# PROPERTY MANAGEMENT CRUD SYSTEM

This project is a CRUD (Create, Read, Update, Delete) system for managing real estate properties. The goal is to build a simple web application that allows users to perform the following operations on property listings:

- Create new property listings.
- Read and view the complete list of properties and their details.
- Update the information of an existing property.
- Delete property listings.

## 🖥️ Server Features

The code is structured into different classes and packages to maintain clean, organized, and scalable architecture. This structure also simplifies future code extensions.

Some of the server's key features include:

- Create and manage properties.
- Search functionality with filters (price, size, address).
- Cloud deployment on AWS.
- User-friendly web interface.

## 📁 Project Structure

```
│──  src
│   ├──  main
│   │   ├──  java
│   │   │   └──  com.eci.AREP_TALLER05_MANUELS
│   │   │       ├──  controller
│   │   │       │   ├── PropertyController.java
│   │   │       ├──  model
│   │   │       │   ├── Property.java
│   │   │       ├── repository
│   │   │       │   ├── PropertyRepository.java
│   │   │       ├── service
│   │   │       │   ├── ApplicationProperty.java
│   │   │       ├── AREP_TALLER05_MANUELSApplication.java
│   │   ├──  resources
│   │   │   ├──  static
│   │   │   │   ├── index.html
│   │   │   │   ├── script.js
│   │   │   │   ├── styles.css
│   │   │   ├──  application.properties
│   ├──  test
│   │   ├── java
│   │   │   ├── PropertyTest.java
│   ├──  target
│   ├──  .gitignore
│   ├──  Dockerfile
│   ├──  LICENSE
│   ├──  README.md
│   ├──  docker-compose.yml
│   ├──  pom.xml
```

## 🛠 Class Design

📄 **Model:** `Property`
- Represents the property in the database.
- Mapped as an entity using JPA/Hibernate.

📄 **Repository:** `PropertyRepository`
- Interface for accessing data with JPA/Hibernate.
- Extends `JpaRepository` to provide CRUD operations.

📄 **Service:** `ApplicationProperty` (💡 We should rename this to `PropertyService` for consistency)
- Contains the business logic.
- Acts as a bridge between the controller and the repository.

📄 **Controller:** `PropertyController`
- Exposes RESTful endpoints to interact with property data.
- Handles HTTP requests (GET, POST, PUT, DELETE).

## 🏛 System Architecture

1. 🧑‍💻 Architecture: MVC (Model-View-Controller)
2. 🚀 Framework: Spring Boot
3. 🗃️ Database: MySQL
4. 🐋 Containerization: Docker
5. ☁️ Cloud Deployment: AWS
6. 🔄 CI/CD: GitHub Actions
7. 📝 API Documentation: Swagger

## 🚀 Deployment

![Video](src/resources/video.mp4)

## 👤 Author

* **ManuelSuarez07**

## 🧰 Technologies Used

- Java, HTML, JavaScript, CSS
- Maven
- AWS
- Spring Boot
- MySQL
- Docker
- Swagger
- GitHub Actions
