package com.crs.controller;

import com.crs.entity.Course;
import com.crs.service.custom.CourseService;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class CourseController {

    @FXML
    private ListView<String> courseListView;

    private final CourseService courseService = new CourseService();

    @FXML
    public void initialize() {
        loadCourses();
    }

    private void loadCourses() {
        List<Course> courses = courseService.getAllCourses();
        courseListView.getItems().clear();
        for (Course c : courses) {
            courseListView.getItems().add(c.getTitle() + " (" + c.getCreditHours() + " credits)");
        }
    }
}