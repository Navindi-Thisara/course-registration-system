package com.crs.controller;

import com.crs.entity.Student;
import com.crs.service.custom.StudentService;
import com.crs.service.custom.impl.StudentServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class StudentController {

    @FXML
    private ListView<String> studentListView;

    private final StudentService studentService = new StudentServiceImpl();

    @FXML
    public void initialize() {
        loadStudents();
    }

    private void loadStudents() {
        List<Student> students = studentService.getAllStudents();
        studentListView.getItems().clear();
        for (Student s : students) {
            studentListView.getItems().add(s.getName() + " - " + s.getProgram());
        }
    }
}