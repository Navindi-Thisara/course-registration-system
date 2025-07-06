package com.crs.service;

import com.crs.model.Course;
import com.crs.model.Enrollment;
import com.crs.repository.CourseRepository;
import com.crs.repository.EnrollmentRepository;
import com.crs.repository.PrerequisiteRepository;

import java.util.List;

public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepo = new EnrollmentRepository();
    private final CourseRepository courseRepo = new CourseRepository();
    private final PrerequisiteRepository prereqRepo = new PrerequisiteRepository();

    public boolean enrollStudent(int studentId, int courseId) {
        Course course = courseRepo.getCourseById(courseId);
        if (course == null) {
            System.out.println("Course not found.");
            return false;
        }

        if (enrollmentRepo.getEnrollmentCount(courseId) >= course.getCapacity()) {
            System.out.println("Course capacity reached.");
            return false;
        }

        if (!prereqRepo.hasCompletedPrerequisites(studentId, courseId)) {
            System.out.println("Prerequisites not satisfied.");
            return false;
        }

        return enrollmentRepo.addEnrollment(studentId, courseId);
    }

    public boolean dropEnrollment(int studentId, int courseId) {
        return enrollmentRepo.deleteEnrollment(studentId, courseId);
    }

    public List<Enrollment> getEnrollmentsByStudent(int studentId) {
        return enrollmentRepo.getEnrollmentsByStudent(studentId);
    }

    public List<Enrollment> getEnrollmentsByCourse(int courseId) {
        return enrollmentRepo.getEnrollmentsByCourse(courseId);
    }
}
