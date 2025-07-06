package com.crs.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ScheduleController {

    @FXML
    private TextArea scheduleArea;

    @FXML
    public void viewMySchedule(ActionEvent event) {
        scheduleArea.setText("=== My Schedule ===\n"
                + "Monday    9:00-11:00   Object Oriented Programming\n"
                + "Tuesday  10:00-12:00   Database Systems\n"
                + "Wednesday 1:00-3:00    Software Engineering\n"
                + "(Sample data, implement actual schedule retrieval)");
    }

    @FXML
    public void clearSchedule(ActionEvent event) {
        scheduleArea.clear();
    }
}
