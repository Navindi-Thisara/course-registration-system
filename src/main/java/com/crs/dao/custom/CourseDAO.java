package com.crs.dao.custom;

import com.crs.entity.Course;
import java.util.List;

public interface CourseDAO {
    List<Course> getAllCourses();
    Course getCourseById(int id);
    boolean addCourse(Course course);
    boolean updateCourse(Course course);
    boolean deleteCourse(int id);
}
