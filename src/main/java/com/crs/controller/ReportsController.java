package com.crs.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ReportsController {

    @FXML
    private TextArea reportArea;

    @FXML
    public void generateReport() {
        reportArea.setText("Enrollment & Vacancy Report\n\n(Feature under development)");
    }

    @FXML
    public void viewEnrollments(ActionEvent actionEvent) {
        reportArea.setText("=== Enrollments ===\n" +
                "Student 1 → Course A\n" +
                "Student 2 → Course B\n" +
                "Student 3 → Course A\n" +
                "(Sample data, implement DB fetch later)");
    }

    @FXML
    public void viewVacancies(ActionEvent actionEvent) {
        reportArea.setText("=== Course Vacancies ===\n" +
                "Course A: 10 spots left\n" +
                "Course B: 5 spots left\n" +
                "Course C: 0 spots left (Full)\n" +
                "(Sample data, implement DB fetch later)");
    }
}
