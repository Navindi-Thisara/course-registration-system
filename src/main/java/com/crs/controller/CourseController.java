package com.crs.controller;

import com.crs.model.Course;
import com.crs.service.CourseService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CourseController {

    @FXML private TableView<Course> courseTable;
    @FXML private TableColumn<Course, String> colCourseId;
    @FXML private TableColumn<Course, String> colTitle;
    @FXML private TableColumn<Course, Integer> colCredits;

    @FXML private TextField txtCourseId;
    @FXML private TextField txtTitle;
    @FXML private TextField txtCredits;

    @FXML private Button btnAdd;
    @FXML private Button btnUpdate;
    @FXML private Button btnDelete;

    private final CourseService courseService = new CourseService();

    @FXML
    private void initialize() {
        colCourseId.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colCredits.setCellValueFactory(new PropertyValueFactory<>("creditHours"));

        loadCourses();

        courseTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                txtCourseId.setText(newSel.getCourseId());
                txtTitle.setText(newSel.getTitle());
                txtCredits.setText(String.valueOf(newSel.getCreditHours()));
                txtCourseId.setDisable(true);
            }
        });
    }

    private void loadCourses() {
        ObservableList<Course> list = FXCollections.observableArrayList(courseService.getAllCourses());
        courseTable.setItems(list);
    }

    @FXML
    private void addCourse() {
        String id = txtCourseId.getText().trim();
        String title = txtTitle.getText().trim();
        String creditsStr = txtCredits.getText().trim();

        if (id.isEmpty() || title.isEmpty() || creditsStr.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Please fill all fields.");
            return;
        }

        int credits;
        try {
            credits = Integer.parseInt(creditsStr);
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Credits must be a number.");
            return;
        }

        if (courseService.getCourseById(id) != null) {
            showAlert(Alert.AlertType.ERROR, "Course ID already exists.");
            return;
        }

        Course course = new Course(id, title, credits);
        courseService.addCourse(course);
        loadCourses();
        clearFields();
        showAlert(Alert.AlertType.INFORMATION, "Course added successfully.");
    }

    @FXML
    private void updateCourse() {
        String id = txtCourseId.getText().trim();
        if (id.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Select a course to update.");
            return;
        }

        Course existing = courseService.getCourseById(id);
        if (existing == null) {
            showAlert(Alert.AlertType.ERROR, "Course not found.");
            return;
        }

        existing.setTitle(txtTitle.getText().trim());
        try {
            existing.setCreditHours(Integer.parseInt(txtCredits.getText().trim()));
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Credits must be a number.");
            return;
        }

        courseService.updateCourse(existing);
        loadCourses();
        clearFields();
        showAlert(Alert.AlertType.INFORMATION, "Course updated successfully.");
    }

    @FXML
    private void deleteCourse() {
        Course selected = courseTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert(Alert.AlertType.WARNING, "Select a course to delete.");
            return;
        }

        courseService.deleteCourse(selected.getCourseId());
        loadCourses();
        clearFields();
        showAlert(Alert.AlertType.INFORMATION, "Course deleted successfully.");
    }

    private void clearFields() {
        txtCourseId.clear();
        txtTitle.clear();
        txtCredits.clear();
        txtCourseId.setDisable(false);
        courseTable.getSelectionModel().clearSelection();
    }

    private void showAlert(Alert.AlertType type, String msg) {
        Alert alert = new Alert(type);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
