package com.crs.service;

import com.crs.model.Course;
import com.crs.repository.CourseRepository;
import com.crs.repository.EnrollmentRepository;
import com.crs.repository.PrerequisiteRepository;

public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepo;
    private final CourseRepository courseRepo;
    private final PrerequisiteRepository prereqRepo;

    public EnrollmentService() {
        this.enrollmentRepo = new EnrollmentRepository();
        this.courseRepo = new CourseRepository();
        this.prereqRepo = new PrerequisiteRepository();
    }

    /**
     * Enrolls a student in a course after checking capacity and prerequisites.
     *
     * @param studentId The ID of the student.
     * @param courseId The ID of the course.
     * @return true if enrollment is successful, false otherwise.
     */
    public boolean enrollStudent(int studentId, int courseId) {
        Course course = courseRepo.getCourseById(courseId);
        if (course == null) {
            System.out.println("Course not found.");
            return false;
        }

        int currentEnrollment = enrollmentRepo.getEnrollmentCount(courseId);
        if (currentEnrollment >= course.getCapacity()) {
            System.out.println("Course capacity reached. Current: " + currentEnrollment + ", Capacity: " + course.getCapacity());
            return false;
        }

        boolean hasPrerequisites = prereqRepo.hasCompletedPrerequisites(studentId, courseId);
        if (!hasPrerequisites) {
            System.out.println("Student has not completed the required prerequisites.");
            return false;
        }

        boolean success = enrollmentRepo.addEnrollment(studentId, courseId);
        if (success) {
            System.out.println("Student enrolled successfully.");
        } else {
            System.out.println("Enrollment failed due to a database error.");
        }
        return success;
    }
}
