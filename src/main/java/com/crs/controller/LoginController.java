package com.crs.controller;

import com.crs.model.User;
import com.crs.service.AuthenticationService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    private final AuthenticationService authService = new AuthenticationService();

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        User user = authService.login(username, password);
        if (user != null) {
            switch (user.getRole()) {
                case "Admin" -> loadScene("/view/AdminDashboard.fxml");
                case "Faculty" -> loadScene("/view/FacultyDashboard.fxml");
                case "Student" -> loadScene("/view/StudentDashboard.fxml");
                default -> errorLabel.setText("Unknown role.");
            }
        } else {
            errorLabel.setText("Invalid credentials.");
        }
    }

    private void loadScene(String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
