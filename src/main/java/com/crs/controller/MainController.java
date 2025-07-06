package com.crs.controller;

import com.crs.model.User;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        AuthController authController = new AuthController();
        StudentController studentController = new StudentController();
        CourseController courseController = new CourseController();
        EnrollmentController enrollmentController = new EnrollmentController();
        Scanner scanner = new Scanner(System.in);

        // Login
        User user = authController.login();
        if (user == null) {
            System.out.println("Login failed. Exiting...");
            return;
        }

        System.out.println("Logged in as: " + user.getRole());

        while (true) {
            System.out.println("\n===== Main Menu =====");
            System.out.println("1. List Students");
            System.out.println("2. Add Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. List Courses");
            System.out.println("6. Add Course");
            System.out.println("7. Update Course");
            System.out.println("8. Delete Course");
            System.out.println("9. Enroll Student in Course");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> studentController.listStudents();
                    case 2 -> studentController.addStudent();
                    case 3 -> studentController.updateStudent();
                    case 4 -> studentController.deleteStudent();
                    case 5 -> courseController.listCourses();
                    case 6 -> courseController.addCourse();
                    case 7 -> courseController.updateCourse();
                    case 8 -> courseController.deleteCourse();
                    case 9 -> enrollmentController.enrollStudent();
                    case 0 -> {
                        System.out.println("Exiting... Goodbye!");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
