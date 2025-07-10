package com.crs.controller;

import com.crs.model.Student;
import com.crs.service.StudentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentController {

    @FXML private TableView<Student> studentTable;
    @FXML private TableColumn<Student, String> colId;
    @FXML private TableColumn<Student, String> colName;
    @FXML private TableColumn<Student, String> colProgram;

    @FXML private TextField txtId;
    @FXML private TextField txtName;
    @FXML private TextField txtProgram;

    @FXML private Button btnAdd;
    @FXML private Button btnUpdate;
    @FXML private Button btnDelete;

    private final StudentService studentService = new StudentService();

    @FXML
    private void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colProgram.setCellValueFactory(new PropertyValueFactory<>("program"));

        loadStudents();

        studentTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                txtId.setText(newSel.getStudentId());
                txtName.setText(newSel.getName());
                txtProgram.setText(newSel.getProgram());
                txtId.setDisable(true);  // disable editing ID on update
            }
        });
    }

    private void loadStudents() {
        ObservableList<Student> list = FXCollections.observableArrayList(studentService.getAllStudents());
        studentTable.setItems(list);
    }

    @FXML
    private void addStudent() {
        String id = txtId.getText().trim();
        String name = txtName.getText().trim();
        String program = txtProgram.getText().trim();

        if (id.isEmpty() || name.isEmpty() || program.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Please fill all fields.");
            return;
        }

        if (studentService.getStudentById(id) != null) {
            showAlert(Alert.AlertType.ERROR, "Student ID already exists.");
            return;
        }

        Student student = new Student(id, name, program);
        studentService.addStudent(student);
        loadStudents();
        clearFields();
        showAlert(Alert.AlertType.INFORMATION, "Student added successfully.");
    }

    @FXML
    private void updateStudent() {
        String id = txtId.getText().trim();
        if (id.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Select a student to update.");
            return;
        }

        Student existing = studentService.getStudentById(id);
        if (existing == null) {
            showAlert(Alert.AlertType.ERROR, "Student not found.");
            return;
        }

        existing.setName(txtName.getText().trim());
        existing.setProgram(txtProgram.getText().trim());
        studentService.updateStudent(existing);
        loadStudents();
        clearFields();
        showAlert(Alert.AlertType.INFORMATION, "Student updated successfully.");
    }

    @FXML
    private void deleteStudent() {
        Student selected = studentTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert(Alert.AlertType.WARNING, "Select a student to delete.");
            return;
        }

        studentService.deleteStudent(selected.getStudentId());
        loadStudents();
        clearFields();
        showAlert(Alert.AlertType.INFORMATION, "Student deleted successfully.");
    }

    private void clearFields() {
        txtId.clear();
        txtName.clear();
        txtProgram.clear();
        txtId.setDisable(false);
        studentTable.getSelectionModel().clearSelection();
    }

    private void showAlert(Alert.AlertType type, String msg) {
        Alert alert = new Alert(type);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
