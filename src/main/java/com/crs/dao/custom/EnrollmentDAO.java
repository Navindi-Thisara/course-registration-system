package com.crs.dao.custom;

import com.crs.entity.Enrollment;
import java.util.List;

public interface EnrollmentDAO {
    List<Enrollment> getAllEnrollments();
    Enrollment getEnrollmentById(int id);
    boolean addEnrollment(Enrollment enrollment);
    boolean deleteEnrollment(int id);
}
