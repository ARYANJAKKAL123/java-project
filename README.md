🏥 Hospital Management System - Java
This is a simple Hospital Management System developed using Core Java, JDBC, and PostgreSQL. It allows for basic operations like adding patients, viewing their details, and logging hospital data securely.

📁 Project Structure
bash
Copy
Edit
HospitalManagement/
│
├── Main.java                # Main class to run the application
├── Patient.java             # Defines the Patient model
├── PatientDBManager.java    # Handles database operations
└── HospitalDBLogger.java    # Logs important events to a log file
⚙️ Technologies Used
Java (Core Concepts + OOP + Multithreading)

JDBC (Java Database Connectivity)

PostgreSQL (Relational Database)

Maven (for dependency management)

🚀 Getting Started
Prerequisites
Java JDK 8 or higher

PostgreSQL installed and running

Maven installed

Database Setup
Open PostgreSQL and run the following SQL command to create a database and table:

sql
Copy
Edit
CREATE DATABASE hospital;

\c hospital

CREATE TABLE patients (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    gender VARCHAR(10),
    diagnosis TEXT
);
Update your database credentials in PatientDBManager.java:

java
Copy
Edit
String url = "jdbc:postgresql://localhost:5432/hospital";
String user = "your_db_username";
String password = "your_db_password";
🧪 How to Run
Clone the project or download the .java files.

Compile the project:

bash
Copy
Edit
javac *.java
Run the main class:

bash
Copy
Edit
java Main
🧩 Features
Add new patient records

View patient information

Logs operations to a text file for tracking (hospital.log)

JDBC with PreparedStatements for secure SQL

Error handling and logging

📌 Notes
Make sure the PostgreSQL server is running before executing the program.

Log files will be created automatically in the project directory.

You can add more features like update/delete/search using similar patterns.

📄 License
This project is open-source and free to use under the MIT License

MEMBERS:
       1)ARYAN JAKKAL
       2)GOURIPRASAD TUMMA
       3)ARYA HARIDAS