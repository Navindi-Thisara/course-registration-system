package com.crs.controller;

import com.crs.model.Course;
import com.crs.model.Student;
import com.crs.service.CourseService;
import com.crs.service.EnrollmentService;
import com.crs.service.StudentService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EnrollmentController {

    @FXML
    private ComboBox<Student> comboStudents;

    @FXML
    private ComboBox<Course> comboCourses;

    @FXML
    private Button btnEnroll;

    @FXML
    private Button btnDrop;

    @FXML
    private Label lblStatus;

    private final StudentService studentService = new StudentService();
    private final CourseService courseService = new CourseService();
    private final EnrollmentService enrollmentService = new EnrollmentService();

    @FXML
    public void initialize() {
        // Load students and courses into combo boxes
        comboStudents.setItems(FXCollections.observableArrayList(studentService.getAllStudents()));
        comboCourses.setItems(FXCollections.observableArrayList(courseService.getAllCourses()));
    }

    @FXML
    private void handleEnroll() {
        Student student = comboStudents.getValue();
        Course course = comboCourses.getValue();

        if (student == null || course == null) {
            showStatus("Select both student and course to enroll.", Alert.AlertType.WARNING);
            return;
        }

        boolean success = enrollmentService.enrollStudentInCourse(student.getStudentId(), course.getCourseId());

        if (success) {
            showStatus("Successfully enrolled " + student.getName() + " in " + course.getTitle(), Alert.AlertType.INFORMATION);
        } else {
            showStatus("Failed to enroll student. Check prerequisites or capacity.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleDrop() {
        Student student = comboStudents.getValue();
        Course course = comboCourses.getValue();

        if (student == null || course == null) {
            showStatus("Select both student and course to drop.", Alert.AlertType.WARNING);
            return;
        }

        boolean success = enrollmentService.dropStudentFromCourse(student.getStudentId(), course.getCourseId());

        if (success) {
            showStatus("Successfully dropped " + student.getName() + " from " + course.getTitle(), Alert.AlertType.INFORMATION);
        } else {
            showStatus("Failed to drop student from course.", Alert.AlertType.ERROR);
        }
    }

    private void showStatus(String message, Alert.AlertType alertType) {
        lblStatus.setText(message);
        Alert alert = new Alert(alertType);
        alert.setTitle("Enrollment Status");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
