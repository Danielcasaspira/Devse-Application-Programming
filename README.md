# Devsu-Application-Programming


## Overview

The Financial Microservices Application is a distributed system composed of two primary microservices: `client-service` and `operations-service`. These services are designed to handle operations related to clients, accounts, and transactions in a financial system. The application leverages Spring Boot, Spring Data JPA, and RabbitMQ to ensure robust, scalable, and resilient communication and data management.

## Architecture

### Microservices

1. **Client-Service**
   - Manages client information.
   - Handles CRUD operations for clients.
   - Publishes client data to RabbitMQ for other services to consume.

2. **Operations-Service**
   - Manages account information and transactions.
   - Handles CRUD operations for accounts and transactions.
   - Consumes client data from RabbitMQ to ensure data consistency and integrity.

### Communication

- **Asynchronous Communication**: The microservices communicate asynchronously using RabbitMQ, ensuring decoupled and resilient interactions.
- **Database**: Each microservice uses PostgreSQL for persistent data storage.

## Features

### Cliente-Service

- **Create, Read, Update, Delete (CRUD) operations for clients**.
- **Publishes client data to RabbitMQ** to keep other services updated.
- **Validation**: Ensures data integrity and validation for client information.

### Cuenta-Service

- **CRUD operations for accounts**: Manage account creation, updates, and deletions.
- **Transaction Management**: Handle transactions, update account balances, and log transaction history.
- **Client Data Consumption**: Consumes client information from RabbitMQ to maintain data consistency.
- **Error Handling**: Custom exceptions and global exception handling to manage scenarios such as insufficient balance with clear error messages.

## Technologies Used

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **RabbitMQ**
- **PostgreSQL**
- **Docker**
- **Karate** for integration testing
- **JUnit 5** for unit testing

## Getting Started

### Prerequisites

- Docker
- Docker Compose
- Java 17
- Maven

### Running the Application

1. **Clone the repository**:
   ```sh
   git clone <repository-url>
   cd financial-microservices
