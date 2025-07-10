package com.crs.service.custom.impl;

import com.crs.dao.custom.EnrollmentDAO;
import com.crs.dao.custom.impl.EnrollmentDAOImpl;
import com.crs.entity.Enrollment;
import com.crs.service.custom.EnrollmentService;

import java.util.List;

public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentDAO enrollmentDAO = new EnrollmentDAOImpl();

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentDAO.getAllEnrollments();
    }

    @Override
    public Enrollment getEnrollmentById(int id) {
        return enrollmentDAO.getEnrollmentById(id);
    }

    @Override
    public boolean addEnrollment(Enrollment enrollment) {
        return enrollmentDAO.addEnrollment(enrollment);
    }

    @Override
    public boolean deleteEnrollment(int id) {
        return enrollmentDAO.deleteEnrollment(id);
    }
}
