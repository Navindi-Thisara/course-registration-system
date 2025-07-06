package com.crs.service;

import com.crs.model.Course;
import com.crs.repository.CourseRepository;

import java.util.List;

public class CourseService {

    private final CourseRepository courseRepository = new CourseRepository();

    public boolean addCourse(Course course) {
        return courseRepository.addCourse(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    public Course getCourseById(int courseId) {
        return courseRepository.getCourseById(courseId);
    }

    public boolean updateCourse(Course course) {
        return courseRepository.updateCourse(course);
    }

    public boolean deleteCourse(int courseId) {
        return courseRepository.deleteCourse(courseId);
    }
}
