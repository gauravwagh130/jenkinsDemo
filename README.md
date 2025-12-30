# Banking System Simulator – Microservices Architecture

## Overview
This project is a **Banking System Simulator** built using **Spring Boot Microservices Architecture**.  
It follows **industry-level best practices** such as service discovery, API gateway routing, fault tolerance, asynchronous communication, and centralized logging.

The system is refactored from a monolithic design into multiple independent microservices.

---

## Architecture Diagram

---<img width="613" height="688" alt="image" src="https://github.com/user-attachments/assets/f4676845-7bde-452c-9212-680f69ce9b73" />


## Microservices Details

### 1️⃣ Eureka Server
- **Purpose:** Service discovery
- **Port:** `8761`
- **URL:** http://localhost:8761

---

### 2️⃣ API Gateway
- **Purpose:** Single entry point for all clients
- **Port:** `8080`
- **Routes:**
  - `/api/accounts/** → Account Service`
  - `/api/transactions/** → Transaction Service`
  - `/api/notifications/** → Notification Service`

---

### 3️⃣ Account Service
- **Port:** `8081`
- **Database:** MongoDB (`accounts_db`)
- **Responsibilities:**
  - Create account
  - Fetch account details
  - Update balance
  - Activate / Deactivate account

---

### 4️⃣ Transaction Service
- **Port:** `8082`
- **Database:** MongoDB (`transactions_db`)
- **Responsibilities:**
  - Deposit
  - Withdraw
  - Transfer
  - Publish Kafka events
- **Fault Tolerance:** Resilience4j Circuit Breaker

---

### 5️⃣ Notification Service
- **Port:** `8083`
- **Responsibilities:**
  - Consume Kafka events
  - Send simulated notifications (logs)

---

### 6️⃣ Kafka
- **Topic:** `transaction-events`
- Used for asynchronous communication between Transaction and Notification services.

---

## Technology Stack
- Java 17
- Spring Boot 3.x
- Spring Cloud (Eureka, Gateway, OpenFeign)
- MongoDB
- Apache Kafka
- Resilience4j
- Docker & Docker Compose
- JUnit & Mockito

---

## Service Ports Summary

| Service | Port |
|------|------|
| Eureka Server | 8761 |
| API Gateway | 8080 |
| Account Service | 8081 |
| Transaction Service | 8082 |
| Notification Service | 8083 |

---

## How to Run (Docker)

### Step 1: Start Docker
Ensure Docker Desktop is running.

### Step 2: Build & Run
```bash
docker-compose up --build
```

### Step 3: Verify
- Eureka Dashboard → http://localhost:8761
- Gateway → http://localhost:8080

---

## Sample API Flow
1. Create Account
2. Deposit Amount
3. Transfer Funds
4. Kafka Event Triggered
5. Notification Logged

---

## Testing
- Unit tests using **JUnit 5 + Mockito**
- Service-layer testing
- Controller-layer testing using **MockMvc**

---

