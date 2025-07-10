package com.crs.controller;

import com.crs.service.ReportService;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ReportController {

    @FXML
    private TextArea reportTextArea;

    private final ReportService reportService = new ReportService();

    @FXML
    public void initialize() {
        String report = reportService.generateCourseEnrollmentReport();
        reportTextArea.setText(report);
    }
}