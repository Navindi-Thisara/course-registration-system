package com.crs.service;

import com.crs.model.Student;
import com.crs.repository.StudentRepository;

import java.util.List;

public class StudentService {

    private final StudentRepository studentRepository = new StudentRepository();

    public boolean addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public Student getStudentById(int studentId) {
        return studentRepository.getStudentById(studentId);
    }

    public boolean updateStudent(Student student) {
        return studentRepository.updateStudent(student);
    }

    public boolean deleteStudent(int studentId) {
        return studentRepository.deleteStudent(studentId);
    }
}
