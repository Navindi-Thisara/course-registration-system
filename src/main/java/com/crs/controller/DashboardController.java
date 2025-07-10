package com.crs.controller;

import com.crs.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class DashboardController {

    @FXML private Label welcomeLabel;
    @FXML private Button btnStudents;
    @FXML private Button btnCourses;
    @FXML private Button btnEnrollments;
    @FXML private Button btnLogout;

    private User currentUser;

    public void setUser(User user) {
        this.currentUser = user;
        welcomeLabel.setText("Welcome, " + user.getUsername() + " (" + user.getRole() + ")");
        configureButtonsForRole(user.getRole());
    }

    private void configureButtonsForRole(String role) {
        switch(role.toUpperCase()) {
            case "STUDENT":
                btnStudents.setDisable(true); // students cannot manage other students
                btnCourses.setDisable(false);
                btnEnrollments.setDisable(false);
                break;
            case "FACULTY":
                btnStudents.setDisable(true);
                btnCourses.setDisable(false);
                btnEnrollments.setDisable(true); // faculty may not enroll students
                break;
            case "ADMIN":
                btnStudents.setDisable(false);
                btnCourses.setDisable(false);
                btnEnrollments.setDisable(false);
                break;
            default:
                btnStudents.setDisable(true);
                btnCourses.setDisable(true);
                btnEnrollments.setDisable(true);
        }
    }

    @FXML
    private void handleStudents(ActionEvent event) throws IOException {
        openWindow("/com/crs/view/Students.fxml", "Manage Students");
    }

    @FXML
    private void handleCourses(ActionEvent event) throws IOException {
        openWindow("/com/crs/view/Courses.fxml", "Manage Courses");
    }

    @FXML
    private void handleEnrollments(ActionEvent event) throws IOException {
        openWindow("/com/crs/view/Enrollments.fxml", "Enrollments");
    }

    @FXML
    private void handleLogout(ActionEvent event) {
        // Return to login screen
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/crs/view/Login.fxml"));
            Stage stage = (Stage) btnLogout.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Course Registration System - Login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openWindow(String fxmlPath, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.show();
    }
}
