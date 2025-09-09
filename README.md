# Appointment Scheduler Backend
This is the **Spring Boot Backend** for the Appointment Scheduler project. 
It provides a REST API for managing appointments and customers, and is designed to work with the Appointment Frontend.

---

## Features
- Manage **appointments** (add, edit, delete, list).
- Manage **customers** linked to appointments.
- RESTful API endpoints built with **Spring Boot**.
- In-memory database (**H2**) for easy local testing.

---

## Tech Stack
**Java 17**
**Spring Boot 3**
**Spring Data JPA**
**H2 Database**
**Maven**

---

## Setup & Run
1. Clone the repository:
   ```bash
   git clone https://github.com/DannonGibby/appointment-backend.git
   cd appointment-backend
2. Run with Maven:
   ```bash
   mvn spring-boot:run
3. The API will be available at:
   ```bash
   http://localhost:8080

---

## API Endpoints
### Appointments
- GET /appointments → List all appointments
- POST /appointments → Create a new appointment
- PUT /appointments/{id} → Update an appointment
- DELETE /appointments/{id} → Delete an appointment

### Customers
- GET /customers → List all customers
- POST /customers → Create a new customer
- PUT /customers/{id} → Update a customer
- DELETE /customers/{id} → Delete a customer

- ---

## Testing the API
You can test the endpoints with:
- Postman
- curl
- Or directly with the frontend app [Appointment Frontend](https://github.com/DannonGibby/appointment-frontend)

## Related Repositories
**Frontend:** [Appointment Frontend](https://github.com/DannonGibby/appointment-frontend)
