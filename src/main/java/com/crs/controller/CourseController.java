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
        if (courses == null || courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        for (Course c : courses) {
            System.out.println(c.getCourseId() + " | " + c.getTitle() + " | " + c.getDepartment() + " | " + c.getCreditHours() + " | " + c.getCapacity());
        }
    }

    public void updateCourse() {
        System.out.print("Enter Course ID to Update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Course course = courseService.getCourseById(id);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.print("New Title [" + course.getTitle() + "]: ");
        String title = scanner.nextLine();
        System.out.print("New Credit Hours [" + course.getCreditHours() + "]: ");
        int credits = Integer.parseInt(scanner.nextLine());
        System.out.print("New Department [" + course.getDepartment() + "]: ");
        String dept = scanner.nextLine();
        System.out.print("New Capacity [" + course.getCapacity() + "]: ");
        int capacity = Integer.parseInt(scanner.nextLine());

        course.setTitle(title);
        course.setCreditHours(credits);
        course.setDepartment(dept);
        course.setCapacity(capacity);

        if (courseService.updateCourse(course)) {
            System.out.println("Course updated successfully.");
        } else {
            System.out.println("Update failed.");
        }
    }

    public void deleteCourse() {
        System.out.print("Enter Course ID to Delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (courseService.deleteCourse(id)) {
            System.out.println("Course deleted successfully.");
        } else {
            System.out.println("Delete failed.");
        }
    }
}
