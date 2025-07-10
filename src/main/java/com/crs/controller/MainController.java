package com.crs.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the login.fxml from resources
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/crs/view/login.fxml"));
        Parent root = loader.load();

        // Set stage title
        primaryStage.setTitle("Course Registration System");

        // Set scene with the loaded FXML root node
        primaryStage.setScene(new Scene(root));

        // Show the main window
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}
