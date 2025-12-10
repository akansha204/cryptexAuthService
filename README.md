# CryptexAuthService

Cryptex AuthService is the authentication microservice for the Cryptex Vault system.  
It handles **user registration, login, password hashing, and JWT token generation**, enabling secure communication across all Cryptex microservices.

This service also embeds **email and userId inside JWT claims**, which are later **extracted and validated by other Cryptex microservices** to verify user identity and authorize requests.

---

## Features
- User Registration & Login  
- JWT Token Generation  
- BCrypt Password Hashing  
- Stateless Authentication (No Sessions)  
- PostgreSQL Database Integration  
- Layered Architecture (DTO → Controller → Service → Repo → Entity)  
- Custom JWT Validation Filter for secure endpoints  

---

## Architecture Flow

Below is the simplified flow of how authentication works inside Cryptex-AuthService:

<img width="941" height="792" alt="image" src="https://github.com/user-attachments/assets/b66e675f-d46d-477a-9244-0f502f6f49c1" />

---

## Tech Stack
- **Java 17 / 21**
- **Spring Boot 3.x**
- **Spring Security**
- **JWT (JJWT library)**
- **PostgreSQL + Spring Data JPA**
- **Lombok**

## Endpoints

### **POST** `/api/auth/register`
Registers a new user.

**Request:**
```json
{
  "email": "user@example.com",
  "password": "mypassword"
}
```

### **POST** `/api/auth/login`
Authenticates the user and returns a JWT token.

**Request:**
```json
{
  "email": "user@example.com",
  "password": "mypassword"
}
```
**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR..."
}
```

