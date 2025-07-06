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

        User user = authController.login();
        if (user == null) {
            return;
        }

        System.out.println("Logged in as: " + user.getRole());

        while (true) {
            System.out.println("\n1. List Students\n2. Add Student\n3. List Courses\n4. Add Course\n5. Enroll\n0. Exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> studentController.listStudents();
                case 2 -> studentController.addStudent();
                case 3 -> courseController.listCourses();
                case 4 -> courseController.addCourse();
                case 5 -> enrollmentController.enrollStudent();
                case 0 -> System.exit(0);
            }
        }
    }
}
