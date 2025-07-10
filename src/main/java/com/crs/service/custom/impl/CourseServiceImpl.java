package com.crs.service.custom.impl;

import com.crs.dao.custom.CourseDAO;
import com.crs.dao.custom.impl.CourseDAOImpl;
import com.crs.entity.Course;
import com.crs.service.custom.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private final CourseDAO courseDAO = new CourseDAOImpl();

    @Override
    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }

    @Override
    public Course getCourseById(int id) {
        return courseDAO.getCourseById(id);
    }

    @Override
    public boolean addCourse(Course course) {
        return courseDAO.addCourse(course);
    }

    @Override
    public boolean updateCourse(Course course) {
        return courseDAO.updateCourse(course);
    }

    @Override
    public boolean deleteCourse(int id) {
        return courseDAO.deleteCourse(id);
    }
}
