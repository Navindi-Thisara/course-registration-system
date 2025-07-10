package com.crs.controller;

import com.crs.entity.User;
import com.crs.service.AuthService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private final AuthService authService = new AuthService();

    @FXML
    protected void onLoginButtonClick(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        User user = authService.login(username, password);

        if (user == null) {
            showAlert("Login Failed", "Invalid username or password.");
        } else {
            showAlert("Login Successful", "Welcome, " + user.getRole() + "!");

            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/crs/view/Dashboard.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) usernameField.getScene().getWindow(); // current stage
                stage.setTitle("Dashboard - " + user.getRole());
                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
                showAlert("Error", "Failed to load dashboard.");
            }
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
