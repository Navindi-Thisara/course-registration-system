package com.crs.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AdminDashboardController {

    @FXML
    private void openStudents(ActionEvent event) {
        SceneLoader.load("/view/Students.fxml", event);
    }

    @FXML
    private void openCourses(ActionEvent event) {
        SceneLoader.load("/view/Courses.fxml", event);
    }

    @FXML
    private void openEnrollment(ActionEvent event) {
        SceneLoader.load("/view/Enrollment.fxml", event);
    }

    @FXML
    private void openReports(ActionEvent event) {
        SceneLoader.load("/view/Reports.fxml", event);
    }

    @FXML
    private void openEnrollments(ActionEvent event) {
        SceneLoader.load("/view/Enrollment.fxml", event);
    }
}
