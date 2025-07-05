package com.crs.repository;

import com.crs.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrerequisiteRepository {

    public boolean hasCompletedPrerequisites(int studentId, int courseId) {
        String sql = "SELECT prerequisite_id FROM prerequisites WHERE course_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, courseId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int prerequisiteId = rs.getInt("prerequisite_id");
                    if (!hasCompletedCourse(studentId, prerequisiteId)) {
                        return false; // Prerequisite not completed
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true; // All prerequisites completed
    }

    private boolean hasCompletedCourse(int studentId, int prerequisiteId) {
        String sql = "SELECT * FROM enrollments WHERE student_id = ? AND course_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            stmt.setInt(2, prerequisiteId);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // If a row exists, the prerequisite was completed
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
