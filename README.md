# Appointment Scheduler Backend
This is the **Spring Boot Backend** for the Appointment Scheduler project. 
It provides a REST API for managing appointments and customers, and is designed to work with the Appointment Frontend. The backend is deployed live on **Render**.

---

## Live API
The backend API is hosted on **Render**:
[View Backend API](https://appointment-backend-danngibby.onrender.com)

The frontend communicates with this live backend API, allowing real-time interaction between the UI and database.

---

## Features
- Manage **appointments** (add, edit, delete, list).
- Manage **customers** linked to appointments.
- RESTful API endpoints built with **Spring Boot**.
- Live deployement on Render for production use.
- In-memory database (**H2**) for easy local testing.

---

## Tech Stack
**Java 17**
**Spring Boot 3**
**Spring Data JPA**
**H2 Database**
**Maven**
**Render**

---

## Setup & Run
1. Clone the repository:
   ```
   git clone https://github.com/DannonGibby/appointment-backend.git
   cd appointment-backend
2. Run with Maven:
   ```
   mvn spring-boot:run
3. The API will be available at:
   ```
   http://localhost:8080
   ---
   For production use, the API is hosted on Render and ready to communicate with the frontend.

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
