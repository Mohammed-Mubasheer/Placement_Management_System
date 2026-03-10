Placement Management System

Overview :
The Placement Management System is a web-based application designed to automate and streamline the campus placement process. It helps manage student information, placement schedules, and recruitment activities efficiently. The system reduces manual work and provides structured access to placement-related data for administrators and companies.

Features :
Student registration and profile management
Secure login module for authorized users
Manage student placement data and records
Search functionality to find student details
Placement schedule management
REST API based backend services

Technologies Used :
Backend: Java, Spring Boot
Database: PostgreSQL
API Testing: Postman
Architecture: RESTful API
Build Tool: Maven

System Architecture :
The application follows a layered architecture:
Controller Layer – Handles incoming HTTP requests and API endpoints
Service Layer – Contains business logic and application processing
Repository Layer – Manages database operations using JPA
Database Layer – PostgreSQL for persistent data storage

Modules :

1. Login Module
Provides secure authentication for users. Each user has a unique username and password to access the system.

2. Student Service Module
Handles operations related to student data including:
Student registration
Managing student profiles
Storing academic and placement information

3. Placement Schedule Module
Allows placement administrators or companies to schedule campus recruitment drives and manage related details.

4. Search Module
Allows companies or administrators to search for student records using details like:
Student name
Hall ticket number

API Testing : 
All REST APIs were tested using Postman to verify:
Proper request and response handling
Data validation
API functionality and performance

Project Objective : 
Reduce manual work in campus placement processes
Provide quick access to student placement data
Maintain accurate and organized placement records
Enable companies to easily find eligible candidates

Future Enhancements : 
Add frontend interface using React or Angular
Implement role-based authentication (Admin, Student, Company)
Add email notifications for placement updates
Deploy application using Docker and Cloud platforms

Author

Mohammed Mubasheer
Computer Science Engineering Student

GitHub: https://github.com/Mohammed-Mubasheer
