📌 Overview

The Smart Student Management System is a Java-based desktop application designed to efficiently manage student records with a secure admin panel. It provides CRUD operations, database connectivity with MySQL, and a user-friendly GUI built using Java Swing.

✨ Features

🔐 Admin Panel – Secure login with username & password.

📝 CRUD Operations – Add, update, delete, and view student records.

💾 Database Connectivity – Integrated with MySQL using JDBC.

🎨 User-Friendly GUI – Interactive interface built with Swing.

🔎 Search & Filter – Find students by roll number, name, or email.

📊 Marks & Grades Management – Store and manage academic performance.

⚠️ Validation & Error Handling – Proper checks and alerts for invalid inputs.

🔒 Security – Password-protected access with restricted admin control.

📈 Scalable – Can be extended with modules like attendance, fees, or reports.

🛠️ Tech Stack

Programming Language: Java

GUI: Java Swing

Database: MySQL

Database Connectivity: JDBC

📂 Project Structure
SmartStudentManagement/
│── src/
│   ├── AdminPanel.java
│   ├── DatabaseConnectivity.java
│   ├── Database.java
│   └── ...
│── resources/
│   ├── background1.png
│   ├── untitleddesign.png
│── README.md

⚙️ Installation & Setup

Clone the repository:

git clone https://github.com/your-username/SmartStudentManagement.git
cd SmartStudentManagement


Import the project into your IDE (IntelliJ IDEA / Eclipse / NetBeans).

Setup the MySQL Database:

CREATE DATABASE studentmanagement;
USE studentmanagement;

CREATE TABLE studentinfo (
    rollno INT PRIMARY KEY,
    name VARCHAR(50),
    contact VARCHAR(15),
    email VARCHAR(100),
    marks INT,
    grade VARCHAR(5)
);


Update your database credentials in DatabaseConnectivity.java.

Run the project:

javac AdminPanel.java
java AdminPanel

📸 Screenshots

(Add your project screenshots here – login panel, student dashboard, etc.)

🚀 Future Enhancements

Attendance management system.

Report card generation (PDF/Excel export).

Role-based access (Admin, Teacher, Student).

Cloud database integration.

Mobile app integration.

👨‍💻 Author

Garv Madaan
📧 vansh0909200@gmail.com
linkedin :https://www.linkedin.com/in/garvmadaan9/
