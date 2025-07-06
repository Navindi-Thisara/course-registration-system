package com.crs.controller;

import com.crs.model.Course;
import com.crs.service.CourseService;

import java.util.List;
import java.util.Scanner;

public class CourseController {
    private final CourseService courseService = new CourseService();
    private final Scanner scanner = new Scanner(System.in);

    public void addCourse() {
        System.out.print("Enter Course Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Credit Hours: ");
        int credits = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Department: ");
        String dept = scanner.nextLine();
        System.out.print("Enter Capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());

        Course course = new Course(0, title, credits, dept, capacity);
        if (courseService.addCourse(course)) {
            System.out.println("Course added successfully.");
        } else {
            System.out.println("Failed to add course.");
        }
    }

    public void listCourses() {
        List<Course> courses = courseService.getAllCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        System.out.println("Course ID | Title | Department | Credit Hours | Capacity");
        for (Course c : courses) {
            System.out.println(c.getCourseId() + " | " +
                    c.getTitle() + " | " +
                    c.getDepartment() + " | " +
                    c.getCreditHours() + " | " +
                    c.getCapacity());
        }
    }

    public void updateCourse() {
        System.out.print("Enter Course ID to update: ");
        int courseId = Integer.parseInt(scanner.nextLine());
        Course course = courseService.getCourseById(courseId);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.print("Enter new Course Title (" + course.getTitle() + "): ");
        String title = scanner.nextLine();
        if (!title.isBlank()) {
            course.setTitle(title);
        }

        System.out.print("Enter new Credit Hours (" + course.getCreditHours() + "): ");
        String creditsStr = scanner.nextLine();
        if (!creditsStr.isBlank()) {
            course.setCreditHours(Integer.parseInt(creditsStr));
        }

        System.out.print("Enter new Department (" + course.getDepartment() + "): ");
        String dept = scanner.nextLine();
        if (!dept.isBlank()) {
            course.setDepartment(dept);
        }

        System.out.print("Enter new Capacity (" + course.getCapacity() + "): ");
        String capacityStr = scanner.nextLine();
        if (!capacityStr.isBlank()) {
            course.setCapacity(Integer.parseInt(capacityStr));
        }

        if (courseService.updateCourse(course)) {
            System.out.println("Course updated successfully.");
        } else {
            System.out.println("Failed to update course.");
        }
    }

    public void deleteCourse() {
        System.out.print("Enter Course ID to delete: ");
        int courseId = Integer.parseInt(scanner.nextLine());

        if (courseService.deleteCourse(courseId)) {
            System.out.println("Course deleted successfully.");
        } else {
            System.out.println("Course not found or failed to delete.");
        }
    }
}
