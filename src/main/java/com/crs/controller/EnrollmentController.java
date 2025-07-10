package com.crs.controller;

import com.crs.service.custom.EnrollmentService;
import com.crs.service.custom.impl.EnrollmentServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EnrollmentController {

    @FXML
    private TextField studentIdField;

    @FXML
    private TextField courseIdField;

    private final EnrollmentService enrollmentService = new EnrollmentServiceImpl();

    @FXML
    protected void onEnrollButtonClick() {
        int studentId = Integer.parseInt(studentIdField.getText());
        int courseId = Integer.parseInt(courseIdField.getText());

        boolean success = enrollmentService.enrollStudent(studentId, courseId);

        if (success) {
            System.out.println("Enrollment successful!");
        } else {
            System.out.println("Enrollment failed (capacity full or prerequisite not met).\n");
        }
    }
}