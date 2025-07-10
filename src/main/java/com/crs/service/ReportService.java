package com.crs.service;

import com.crs.db.DBConnection;

import java.sql.*;

public class ReportService {

    public String generateCourseEnrollmentReport() {
        String sql = "SELECT c.course_id, c.title, c.capacity, COUNT(e.course_id) AS enrolled " +
                "FROM courses c LEFT JOIN enrollments e ON c.course_id = e.course_id " +
                "GROUP BY c.course_id, c.title, c.capacity";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("===== Course Enrollment Report =====");
            while (rs.next()) {
                int enrolled = rs.getInt("enrolled");
                int capacity = rs.getInt("capacity");
                System.out.println("Course: " + rs.getString("title") +
                        " | Enrolled: " + enrolled +
                        " | Capacity: " + capacity +
                        " | Vacancies: " + (capacity - enrolled));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sql;
    }

    public void generateStudentSchedule(int studentId) {
        String sql = "SELECT c.title, e.semester, e.grade " +
                "FROM enrollments e JOIN courses c ON e.course_id = c.course_id " +
                "WHERE e.student_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("===== Student Schedule (Student ID: " + studentId + ") =====");
            while (rs.next()) {
                System.out.println("Course: " + rs.getString("title") +
                        " | Semester: " + rs.getString("semester") +
                        " | Grade: " + rs.getString("grade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void generateAcademicProgressReport() {
        String sql = "SELECT s.student_id, s.name, c.title, e.semester, e.grade " +
                "FROM students s " +
                "JOIN enrollments e ON s.student_id = e.student_id " +
                "JOIN courses c ON e.course_id = c.course_id " +
                "ORDER BY s.student_id, e.semester";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("===== Academic Progress Report =====");
            while (rs.next()) {
                System.out.println("Student: " + rs.getString("name") +
                        " | Course: " + rs.getString("title") +
                        " | Semester: " + rs.getString("semester") +
                        " | Grade: " + rs.getString("grade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
