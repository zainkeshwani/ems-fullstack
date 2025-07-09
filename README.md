# 👩‍💼 Employee Management System – Full Stack Application

This is a full stack **Employee Management System** built with a **React frontend** and a **Spring Boot backend**. It allows users to view, add, update, and delete employee records in a simple and intuitive interface.

## 📚 Tech Stack

- ⚙️ **Backend**: Java, Spring Boot, Spring Data JPA, Maven, MySQL (or H2)
- 💻 **Frontend**: React, Axios, React Router, Bootstrap
- 🌐 **API**: RESTful endpoints
- 💾 **Database**: MySQL (can easily be switched to H2 for testing)

---

## ✨ Features

- View all employees in a responsive table
- Add new employees with a form
- Edit existing employee details
- Delete employees
- RESTful API integration between frontend and backend
- Clean UI with Bootstrap

---

## 🚀 Getting Started

### 🔧 Prerequisites

- Java 17+
- Node.js 16+
- Maven
- MySQL (optional — you can use H2)

---

## ⚙️ Run the Application

### 1. Clone the Repository

git clone https://github.com/your-username/ems-fullstack.git
cd ems-fullstack

### 2. Start the Backend (Spring Boot)
bash
Copy
Edit
cd backend
# If using Maven Wrapper:
./mvnw spring-boot:run

# Or using Maven directly:
mvn spring-boot:run
The backend will start on http://localhost:8080.

### 3. Start the Frontend (React)
bash
Copy
Edit
cd frontend
npm install
npm start
The frontend will run on http://localhost:3000.

### 📂 Project Structure
perl
Copy
Edit
employee-management-system/
├── backend/         # Spring Boot application
│   ├── src/
│   ├── pom.xml
│   └── ...
├── frontend/        # React application
│   ├── src/
│   ├── package.json
│   └── ...
└── README.md

### 🔌 API Endpoints
Method	Endpoint	Description
GET	/api/employees	Get all employees
POST	/api/employees	Add new employee
GET	/api/employees/{id}	Get employee by ID
PUT	/api/employees/{id}	Update employee by ID
DELETE	/api/employees/{id}	Delete employee by ID


🙌 Contributing
Feel free to fork this project and submit pull requests. If you'd like to add features like authentication, pagination, or testing, contributions are welcome!

Made by Zain Keshwani
