# 📚 LibroVault - Book Management System

## 🛠️ Project Overview
**LibroVault** is a full-stack book management system built with **Java Spring Boot** for the backend and **HTML/JavaScript** for the frontend.  
It allows users to:
- View all books
- Add new books
- Search books based on **Author**, **Genre**, or **Price Range**

This project is cleanly organized, beginner-friendly, and ready for further expansion!

---

## 🏠 Project Structure

```
LibroVault/
├── backend/
│   ├── src/main/java/com/nishesh/librovault/
│   │   ├── controller/   -> BookController.java
│   │   ├── model/        -> Book.java
│   │   ├── repository/   -> BookRepository.java
│   │   ├── service/      -> BookService.java
│   │   └── LibroVaultApplication.java
│   ├── src/main/resources/
│   │   └── application.properties
│   └── pom.xml
├── frontend/
│   ├── index.html
│   └── script.js
│   └── style.css 
└── LibroVault_Full_Documentation.pdf
```

---

## 🚀 How to Run the Project

### 1. Backend (Spring Boot)
- Open the project in an IDE like **IntelliJ** or **Eclipse**.
- Make sure you have:
  - **Java 17+**
  - **Maven**
  - **MySQL Server** running
- Create a MySQL database (example: `librovault`).

- Configure **`application.properties`**:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/librovault
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

- Run `LibroVaultApplication.java` ➔ Your backend will start at:  
  `http://localhost:8080/api/books`

---

### 2. Frontend (HTML + JS)
- Open `index.html` in any browser (Chrome recommended).
- It will automatically connect to the backend using **Fetch APIs**.
- Features available:
  - View all books
  - Add a new book
  - Search books by selecting **Author**, **Genre**, or **Price Range**

---

## 🛠️ Technologies Used
| Backend               | Frontend           | Database       | Others                  |
|------------------------|--------------------|----------------|--------------------------|
| Java 17                | HTML5               | MySQL          | Git & GitHub             |
| Spring Boot 3          | JavaScript (Fetch)  |                | Maven                    |
| Spring Web, JPA        | Bootstrap (Optional for CSS) | | VSCode / IntelliJ IDEA |

---

## ✨ Features Explained

- **Cross-Origin Enabled**  
  Using `@CrossOrigin(origins = "*")` to allow frontend and backend communication without CORS issues.

- **BookController**  
  Handles all API requests: create, read, delete, and search books.

- **BookService**  
  Contains business logic for interacting with the database.

- **BookRepository**  
  Interface extending `JpaRepository` for database operations.

- **Frontend JavaScript**  
  - Dynamically fetches and displays books.
  - Posts new book entries.
  - Loads available **authors** and **genres** into dropdowns.
  - Sends search requests based on selected criteria.

---

## 📜 Backend Packages Explained

### 🔹 `com.nishesh.librovault.controller`
- `BookController.java`  ➔ Contains REST APIs for:
  - Adding a book
  - Getting all books
  - Deleting a book
  - Searching by author/genre/price range

### 🔹 `com.nishesh.librovault.model`
- `Book.java`  ➔ Entity class mapping to the database table `books` with fields:
  - id (primary key)
  - title
  - author
  - genre
  - price

### 🔹 `com.nishesh.librovault.repository`
- `BookRepository.java`  ➔ Extends JpaRepository, allowing easy CRUD operations without much boilerplate.

### 🔹 `com.nishesh.librovault.service`
- `BookService.java`  ➔ Business logic to connect controller and repository.

---

## 🕊️ Important Annotations Explained

| Annotation         | Purpose                                  |
|---------------------|------------------------------------------|
| `@RestController`    | Marks class as a REST API controller.    |
| `@RequestMapping`    | Sets the base URL for the controller.    |
| `@GetMapping` / `@PostMapping` / `@DeleteMapping` | Maps HTTP operations to methods. |
| `@Autowired`         | Dependency injection.                  |
| `@RequestParam`      | Binds URL query parameters.             |
| `@PathVariable`      | Binds URL path variables.               |
| `@CrossOrigin`       | Allows cross-origin requests (CORS).    |

---

## 📜 Frontend (index.html + script.js)

- `index.html`
  - Contains form to add books
  - Contains search sections
  - Displays the list of books in a table

- `script.js`
  - Fetches and displays book list
  - Handles adding new books
  - Handles search functionality
  - Populates dropdowns dynamically from backend

---

## 📜 Full Documentation
See the file:  
**`LibroVault_Full_Documentation.pdf`** ➔ contains full explanation of:
- Backend packages
- Controller/Service/Repository layers
- Frontend (HTML + JS)
- Database structure
- How each part communicates with each other.

---

## 🧑‍💼 Author
- **Nishesh**
- Contact: nisheshpokharel@gmail.com

---
