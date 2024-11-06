# Todo Management Project

In this Todo Management Project, you will learn how to build real-time REST APIs and secure them using Spring Security and JWT (JSON Web Token). This backend application provides features to register users, authenticate them, and perform CRUD operations on todos, along with additional functionalities such as marking todos as complete or incomplete.

## Features

- **User Registration and Authentication**: Register and login users with secure JWT-based authentication.
- **CRUD Operations for Todos**: Create, read, update, and delete todos with role-based access control.
- **Mark Todos as Complete or Incomplete**: Update the completion status of todos.
- **Role-Based Access**: Different actions restricted to ADMIN and USER roles.

## Technologies Used

- **Java 17**
- **Spring Boot**
- **Spring Security** with JWT
- **ModelMapper** for DTO mapping
- **Maven** for dependency management

## Getting Started

### Prerequisites

- **Java 17**
- **Maven**
- **Postman** (for API testing, optional)

### Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/sanjaysamsoth/TodoManagement-app.git
   cd TodoManagement-app
2. **Build the Project Using Maven**:
   ```bash
   mvn clean install
3. **Run the Application**:
   ```bash
   mvn spring-boot:run
The application will start on http://localhost:8080.
## API Endpoints
### Authentication and User Management
| Endpoint          | Method | Description                    | Access |
|-------------------|--------|--------------------------------|--------|
| `/api/auth/register` | POST   | Register a new user           | Public |
| `/api/auth/login`    | POST   | Login and obtain a JWT token  | Public |
### Todo Management
| Endpoint                    | Method | Description                           | Access                |
|-----------------------------|--------|---------------------------------------|-----------------------|
| `/api/todos`                | POST   | Add a new todo                        | Admin only            |
| `/api/todos/{id}`           | GET    | Get a specific todo by ID             | Admin, User           |
| `/api/todos`                | GET    | Get all todos                         | Admin, User           |
| `/api/todos/{id}`           | PUT    | Update a todo by ID                   | Admin only            |
| `/api/todos/{id}`           | DELETE | Delete a todo by ID                   | Admin only            |
| `/api/todos/{id}/complete`  | PATCH  | Mark a todo as complete               | Admin, User           |
| `/api/todos/{id}/in-complete` | PATCH | Mark a todo as incomplete             | Admin, User           |
### Request and Response Examples
**Register User**
- **Method**: POST
- **Endpoint**: /api/auth/register
- **Body**:
```json
    {
      "name": "John Doe",
      "username": "john_doe",
      "email": "john@example.com",
      "password": "your_password"
    }
```
**Login User**
- **Method**: POST
- **Endpoint**: /api/auth/login
- **Body**:
```json
{
  "usernameOrEmail": "john_doe",
  "password": "your_password"
}
```
**Create a Todo (Admin Only)**
- **Method**: POST
- **Endpoint**: /api/todos
- **Body**:
```json
{
  "title": "Complete Spring Boot Project",
  "description": "Finish implementing the Todo Management Project",
  "completed": false
}
```
**Response for Created Todo**
- **Body**:
```json
{
  "id": 1,
  "title": "Complete Spring Boot Project",
  "description": "Finish implementing the Todo Management Project",
  "completed": false
}
```
## Role-Based Access
- **Admin** can access all endpoints.
- **USER** can view their todos and mark them as complete or incomplete.
## Security
The application uses **Spring Security** for authentication and authorization, with **JWT** (JSON Web Tokens) to manage user sessions.
1. **Registration and Login**: New users can register, and upon successful registration or login, a JWT token is generated.
2. **Role-Based Access Control**: Endpoints are protected based on roles (ADMIN, USER), restricting actions accordingly.
## Testing the API with Postman
1. **Register** a new user using the /api/auth/register endpoint.
2. **Login** with the registered user credentials using the /api/auth/login endpoint to obtain a JWT token.
3. Use the token in the Authorization header (as a Bearer token) for subsequent requests to the protected endpoints.
