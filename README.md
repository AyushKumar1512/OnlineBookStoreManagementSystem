# 📚 Online Bookstore Management System

A full-fledged Spring Boot application that simulates an **Online Bookstore**, allowing customers to browse and order books, and administrators to manage inventory and users.

---

## 🚀 Features

### 👥 User Management
- Role-based access: `Customer` and `Admin`
- Customer registration with encrypted passwords
- Spring Security authentication & authorization
- Customers can only access their orders; admins can manage everything

### 📚 Book Management
- Admins: Add, update, delete books
- Customers: View, search, and filter books
- Pagination and sorting
- Filter by title, author, genre

### 🛒 Order Management
- Place orders with multiple books
- View customer-specific order history
- Admins can view all orders
- Automatic stock update upon ordering

### 📦 Inventory Management
- Stock validation before order placement
- Low stock alert when below threshold (e.g., < 5 copies)

### 📋 Exception Handling
- Global error handling using `@ControllerAdvice`
- Custom error responses for:
  - Book not found
  - Insufficient stock
  - Invalid input

### 📖 API Documentation
- Swagger/OpenAPI integration for interactive API docs

### 🗄️ Database
- Spring Data JPA with MySQL (or H2 for development)
- Entity relationships: `User`, `Book`, `Order`

### 🛠️ Bonus Features
- Email notifications on successful order (optional)
- Discount system for large orders (optional)
- Caching using Spring Cache (optional)

---

## 🛠️ Tech Stack

| Layer              | Tech Used                          |
|--------------------|------------------------------------|
| Backend Framework  | Spring Boot                        |
| Security           | Spring Security + BCrypt           |
| Database           | MySQL / H2 + Spring Data JPA       |
| Documentation      | Swagger / OpenAPI                  |
| Testing            | JUnit, Mockito, Spring Boot Test   |
| Logging            | Logback, SLF4J                     |
| Build Tool         | Maven / Gradle                     |
| Version Control    | Git + GitHub                       |

