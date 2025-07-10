package com.crs.controller;

import com.crs.model.Student;
import com.crs.service.StudentService;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.Optional;

public class StudentController {

    @FXML private TableView<Student> studentTable;
    @FXML private TableColumn<Student, Integer> idColumn;
    @FXML private TableColumn<Student, String> nameColumn;
    @FXML private TableColumn<Student, String> dobColumn;
    @FXML private TableColumn<Student, String> programColumn;
    @FXML private TableColumn<Student, Integer> yearColumn;
    @FXML private TableColumn<Student, String> contactColumn;
    @FXML private TableColumn<Student, Integer> userIdColumn;

    @FXML private TextField nameField;
    @FXML private TextField dobField;
    @FXML private TextField programField;
    @FXML private TextField yearField;
    @FXML private TextField contactField;
    @FXML private TextField userIdField;

    private final StudentService studentService = new StudentService();
    private final ObservableList<Student> studentData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        idColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getStudentId()).asObject());
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        dobColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDob()));
        programColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProgram()));
        yearColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getYear()).asObject());
        contactColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContactInfo()));
        userIdColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getUserId()).asObject());

        refreshTable();

        studentTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> populateFields(newValue));
    }

    private void populateFields(Student student) {
        if (student != null) {
            nameField.setText(student.getName());
            dobField.setText(student.getDob());
            programField.setText(student.getProgram());
            yearField.setText(String.valueOf(student.getYear()));
            contactField.setText(student.getContactInfo());
            userIdField.setText(String.valueOf(student.getUserId()));
        } else {
            clearFields();
        }
    }

    @FXML
    public void addStudent() {
        try {
            Student student = new Student(
                    0,
                    nameField.getText(),
                    dobField.getText(),
                    programField.getText(),
                    Integer.parseInt(yearField.getText()),
                    contactField.getText(),
                    Integer.parseInt(userIdField.getText())
            );

            if (studentService.addStudent(student)) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Student added successfully.");
                refreshTable();
                clearFields();
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to add student.");
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Year and User ID must be valid numbers.");
        }
    }

    @FXML
    public void updateStudent() {
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
        if (selectedStudent == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a student to update.");
            return;
        }
        try {
            selectedStudent.setName(nameField.getText());
            selectedStudent.setDob(dobField.getText());
            selectedStudent.setProgram(programField.getText());
            selectedStudent.setYear(Integer.parseInt(yearField.getText()));
            selectedStudent.setContactInfo(contactField.getText());
            selectedStudent.setUserId(Integer.parseInt(userIdField.getText()));

            if (studentService.updateStudent(selectedStudent)) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Student updated successfully.");
                refreshTable();
                clearFields();
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to update student.");
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Year and User ID must be valid numbers.");
        }
    }

    @FXML
    public void deleteStudent() {
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
        if (selectedStudent == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a student to delete.");
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirm Deletion");
        confirm.setHeaderText(null);
        confirm.setContentText("Are you sure you want to delete student: " + selectedStudent.getName() + "?");

        Optional<ButtonType> result = confirm.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            if (studentService.deleteStudent(selectedStudent.getStudentId())) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Student deleted successfully.");
                refreshTable();
                clearFields();
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to delete student.");
            }
        }
    }

    private void refreshTable() {
        studentData.setAll(studentService.getAllStudents());
        studentTable.setItems(studentData);
    }

    private void clearFields() {
        nameField.clear();
        dobField.clear();
        programField.clear();
        yearField.clear();
        contactField.clear();
        userIdField.clear();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void listStudents() {

    }
}
