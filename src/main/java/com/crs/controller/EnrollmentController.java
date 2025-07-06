package com.crs.controller;

import com.crs.model.Enrollment;
import com.crs.service.EnrollmentService;

import java.util.List;
import java.util.Scanner;

public class EnrollmentController {
    private final EnrollmentService enrollmentService = new EnrollmentService();
    private final Scanner scanner = new Scanner(System.in);

    public void enrollStudent() {
        System.out.print("Enter Student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Course ID: ");
        int courseId = Integer.parseInt(scanner.nextLine());

        if (enrollmentService.enrollStudent(studentId, courseId)) {
            System.out.println("Enrollment successful.");
        } else {
            System.out.println("Enrollment failed.");
        }
    }

    public void dropEnrollment() {
        System.out.print("Enter Student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Course ID: ");
        int courseId = Integer.parseInt(scanner.nextLine());

        if (enrollmentService.dropEnrollment(studentId, courseId)) {
            System.out.println("Enrollment dropped successfully.");
        } else {
            System.out.println("Failed to drop enrollment.");
        }
    }

    public void viewEnrollmentsByStudent() {
        System.out.print("Enter Student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());

        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudent(studentId);
        if (enrollments.isEmpty()) {
            System.out.println("No enrollments found for student ID: " + studentId);
        } else {
            System.out.println("Enrollments for student ID " + studentId + ":");
            for (Enrollment e : enrollments) {
                System.out.println("Course ID: " + e.getCourseId() + ", Enrollment Date: " + e.getEnrollmentDate());
            }
        }
    }

}
