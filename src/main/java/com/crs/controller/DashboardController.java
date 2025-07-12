package com.crs.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    @FXML
    protected void onManageStudentsClick(ActionEvent event) throws IOException {
        loadScene("/view/students.fxml", "Manage Students", event);
    }

    @FXML
    protected void onManageCoursesClick(ActionEvent event) throws IOException {
        loadScene("/view/courses.fxml", "Manage Courses", event);
    }

    @FXML
    protected void onManageEnrollmentsClick(ActionEvent event) throws IOException {
        loadScene("/view/enrollments.fxml", "Manage Enrollments", event);
    }

    @FXML
    protected void onViewReportsClick(ActionEvent event) throws IOException {
        loadScene("/view/reports.fxml", "Reports", event);
    }

    @FXML
    protected void onLogoutClick(ActionEvent event) throws IOException {
        loadScene("/view/login.fxml", "Login", event);
    }

    private void loadScene(String fxmlPath, String title, ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
