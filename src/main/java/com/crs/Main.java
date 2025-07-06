package com.crs;

import com.crs.controller.AuthController;
import com.crs.controller.StudentController;
import com.crs.controller.CourseController;
import com.crs.controller.EnrollmentController;
import com.crs.model.User;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthController authController = new AuthController();
        StudentController studentController = new StudentController();
        CourseController courseController = new CourseController();
        EnrollmentController enrollmentController = new EnrollmentController();

        System.out.println("=== Course Registration System ===");

        // Login First
        User loggedInUser = null;
        while (loggedInUser == null) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            loggedInUser = authController.login(username, password);
        }

        System.out.println("Welcome, " + loggedInUser.getUsername() + " (" + loggedInUser.getRole() + ")");

        boolean running = true;
        while (running) {
            System.out.println("\n1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Add Course");
            System.out.println("4. List Courses");
            System.out.println("5. Enroll Student in Course");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    studentController.addStudent();
                    break;
                case "2":
                    studentController.listStudents();
                    break;
                case "3":
                    courseController.addCourse();
                    break;
                case "4":
                    courseController.listCourses();
                    break;
                case "5":
                    enrollmentController.enrollStudent();
                    break;
                case "0":
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
