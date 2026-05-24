# Sprintboot Playground

A learning playground for experimenting with Spring Boot REST APIs, covering CRUD operations, controller-service-model architecture, and Postman testing.

This repo is designed to understand backend fundamentals in Spring Boot using practical examples.

---

# 📂 Project Structure

```text
Sprintboot-playground/
│
├── RESTusingSpringboot/   -> Main Spring Boot project
├── .idea/                 -> IntelliJ configuration
├── notes.md               -> Learning notes and references
```

---

# 🚀 Features

- CRUD Operations (Create, Read, Update, Delete)
- REST API endpoints using Spring Boot
- Controller-Service-Model layered architecture
- Postman testing for APIs
- JSON request and response handling using Jackson

---

# 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Maven
- Postman

---

# ⚙️ Setup & Run

## 1. Clone Repository

```bash
git clone https://github.com/nitinshas3/Sprintboot-playground.git
```

```bash
cd Sprintboot-playground/RESTusingSpringboot
```

---

## 2. Build Project

```bash
mvn clean install
```

---

## 3. Run Application

```bash
mvn spring-boot:run
```

Application runs at:

```text
http://localhost:8080
```

---

# 📡 Example Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | /products | Fetch all products |
| GET | /products/{id} | Fetch product by ID |
| POST | /products | Create new product |
| PUT | /products/{id} | Update product |
| DELETE | /products/{id} | Delete product |

---

# 🧪 Postman Testing

Example JSON request body:

```json
{
  "pid": 1,
  "name": "Laptop",
  "price": 1200
}
```

Use Postman to:

- Send GET requests
- Send POST requests with JSON body
- Test PUT updates
- Test DELETE operations

---

# 🏗️ Architecture

```text
Client Request
      ↓
Controller Layer
      ↓
Service Layer
      ↓
Model/Data Layer
      ↓
Response Returned
```

---

# 📖 Learning Topics Covered

- Spring Boot basics
- REST APIs
- CRUD mappings
- @GetMapping
- @PostMapping
- @PutMapping
- @DeleteMapping
- RequestBody
- PathVariable
- JSON handling with Jackson
- Layered Architecture
- Postman testing

---

# 👨‍💻 Author

Nitin S Shastri

GitHub:
https://github.com/nitinshas3