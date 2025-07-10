package com.crs.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    @FXML
    protected void onManageStudentsClick(ActionEvent event) throws IOException {
        loadScene("/com/crs/view/students.fxml", "Manage Students");
    }

    @FXML
    protected void onManageCoursesClick(ActionEvent event) throws IOException {
        loadScene("/com/crs/view/courses.fxml", "Manage Courses");
    }

    @FXML
    protected void onManageEnrollmentsClick(ActionEvent event) throws IOException {
        loadScene("/com/crs/view/enrollments.fxml", "Manage Enrollments");
    }

    @FXML
    protected void onViewReportsClick(ActionEvent event) throws IOException {
        loadScene("/com/crs/view/reports.fxml", "Reports");
    }

    @FXML
    protected void onLogoutClick(ActionEvent event) throws IOException {
        loadScene("/com/crs/view/login.fxml", "Login");
    }

    private void loadScene(String fxmlPath, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();

        // Close current window
        Stage currentStage = (Stage) loader.getRoot().getScene().getWindow();
        currentStage.close();
    }
}