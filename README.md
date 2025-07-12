# 🎓 Course Registration System (CRS)

A JavaFX-based application to automate the course registration process for educational institutions. It simplifies managing student enrollments, courses, and academic records.

---

## 📂 Project Structure

```
course-registration-system/
├── src/main/java/com/crs/
│   ├── controller/      # JavaFX Controllers
│   ├── service/         # Business Logic Layer
│   ├── dao/             # Data Access Layer (JDBC)
│   ├── entity/          # Entity Classes
│   ├── dto/             # Data Transfer Objects (optional)
│   ├── lib/             # External Libraries
│   └── db/              # Utilities (DBConnection, Validators)
│
├── src/main/resources/
│   ├── view/            # FXML Layouts for JavaFX
│   └── application.properties # Database connection settings
│
├── database/            # crs_db_dump.sql
└── pom.xml              # Maven Build File
```

---

## ✅ Features

* User login with **role-based access control** (Admin, Student, Faculty)
* CRUD operations for:

  * Students
  * Courses
  * Enrollments
* Automated **prerequisite checking** during registration
* Course capacity management
* Real-time enrollment updates
* Reports on course registrations and student academic progress
* **JavaFX GUI** for user-friendly interaction

---

## ⚙️ System Requirements

| Requirement          | Version/Details                              |
| -------------------- | -------------------------------------------- |
| Java Development Kit | 21 or later                                  |
| JavaFX SDK           | 21.0.1                                       |
| MySQL Server         | 8.x                                          |
| Maven                | 3.8+                                         |
| IDE                  | IntelliJ IDEA / Eclipse / VS Code (optional) |
| OS                   | Windows / Linux / MacOS                      |

---

## 🔧 Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/Navindi-Thisara/course-registration-system.git
cd course-registration-system
```

### 2. Setup MySQL Database

* Create a MySQL database:

```sql
CREATE DATABASE crs_db;
```

* Import the provided dump:

```bash
mysql -u root -p crs_db < database/crs_db_dump.sql
```

### 3. Configure Database Connection

Edit `src/main/resources/application.properties`:

```properties
db.url=jdbc:mysql://localhost:3306/crs_db
db.username=root
db.password=your_password
```

### 4. Build the Project

Using Maven:

```bash
mvn clean install
```

### 5. Run the Application

```bash
mvn clean javafx:run
```

---

## 🔑 Default Login Credentials (for testing)

| Role    | Username | Password   |
| ------- | -------- | ---------- |
| Admin   | admin    | admin123   |
| Student | student1 | student123 |
| Faculty | faculty1 | faculty123 |

---

## 👥 User Roles & Functionalities

### 🕫️ Admin

* Manage students & courses (Add/Edit/Delete)
* Enroll students
* Generate reports
* View all data

### 🎓 Student

* View available courses
* Register/drop courses
* View enrolled courses

### 👨‍🏫 Faculty

* View courses assigned to them
* View enrolled students in their courses
* Update student grades
* Generate academic progress reports for their courses
* Monitor course enrollment capacity and student lists
  
---

## 🔮 Sample Screens

* **Login Page:** `/view/Login.fxml`
* **Dashboard:** `/view/Dashboard.fxml`
* **Students Management:** `/view/Students.fxml`
* **Courses Management:** `/view/Courses.fxml`
* **Enrollment Management:** `/view/Enrollments.fxml`
* **Reports:** `/view/Reports.fxml`
  
---

## 📊 Example Reports

* Course Enrollment Summary
* Available Course Slots
* Student Course List

---

## 🔍 Troubleshooting

| Issue                   | Solution                                        |
| ----------------------- | ----------------------------------------------- |
| Cannot connect to MySQL | Check MySQL service and credentials             |
| FXML file not found     | Ensure correct path (`src/main/resources/view`) |
| JavaFX runtime errors   | Confirm JavaFX SDK setup and VM arguments       |
| Build failure           | Run `mvn clean install -U`                      |

---

## 🤝 Contribution

* Fork this repository.
* Create a new branch: `feature/your-feature`
* Commit your changes.
* Open a pull request.

---

## 📃 License

This project is licensed under the MIT License.

---

## 📧 Contact

Created by **Navindi Thisara** – Feel free to reach out for questions or collaborations.

* GitHub: [Navindi-Thisara](https://github.com/Navindi-Thisara)
* Email: navindithisara214@gmail.com

---

✅ *Course Registration System - Simplifying Academic Management*
