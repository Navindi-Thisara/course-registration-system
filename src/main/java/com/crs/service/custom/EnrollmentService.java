package com.crs.service.custom;

import com.crs.entity.Enrollment;
import java.util.List;

public interface EnrollmentService {
    List<Enrollment> getAllEnrollments();
    Enrollment getEnrollmentById(int id);
    boolean addEnrollment(Enrollment enrollment);
    boolean deleteEnrollment(int id);

    boolean enrollStudent(int studentId, int courseId);
}
