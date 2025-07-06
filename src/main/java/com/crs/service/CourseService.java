package com.crs.service;

import com.crs.model.Course;
import com.crs.repository.CourseRepository;

import java.util.List;

public class CourseService {
    private final CourseRepository courseRepo = new CourseRepository();

    public boolean addCourse(Course course) {
        try {
            courseRepo.addCourse(course);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Course> getAllCourses() {
        return courseRepo.getAllCourses();
    }

    public Course getCourseById(int courseId) {
        return courseRepo.getCourseById(courseId);
    }

    public boolean updateCourse(Course course) {
        try {
            courseRepo.updateCourse(course);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCourse(int courseId) {
        try {
            courseRepo.deleteCourse(courseId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
