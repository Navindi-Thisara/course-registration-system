package com.crs.dao.custom;

import com.crs.entity.Student;
import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudents();
    Student getStudentById(int id);
    boolean addStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(int id);
}
