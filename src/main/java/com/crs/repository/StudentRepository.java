package com.crs.repository;

import com.crs.model.Student;
import com.crs.util.DBConnection;

import java.sql.*;

public class StudentRepository {

    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, dob, program, year, contact_info, user_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getName());
            stmt.setString(2, student.getDob());
            stmt.setString(3, student.getProgram());
            stmt.setInt(4, student.getYear());
            stmt.setString(5, student.getContactInfo());
            stmt.setInt(6, student.getUserId());

            stmt.executeUpdate();
            System.out.println("Student added successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllStudents() {
        String sql = "SELECT * FROM students";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt("student_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("program") + " | " +
                        rs.getString("dob") + " | " +
                        rs.getInt("year") + " | " +
                        rs.getString("contact_info") + " | " +
                        rs.getInt("user_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student getStudentById(int studentId) {
        String sql = "SELECT * FROM students WHERE student_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                            rs.getInt("student_id"),
                            rs.getString("name"),
                            rs.getString("dob"),
                            rs.getString("program"),
                            rs.getInt("year"),
                            rs.getString("contact_info"),
                            rs.getInt("user_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateStudent(Student student) {
        String sql = "UPDATE students SET name = ?, dob = ?, program = ?, year = ?, contact_info = ?, user_id = ? WHERE student_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getName());
            stmt.setString(2, student.getDob());
            stmt.setString(3, student.getProgram());
            stmt.setInt(4, student.getYear());
            stmt.setString(5, student.getContactInfo());
            stmt.setInt(6, student.getUserId());
            stmt.setInt(7, student.getStudentId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("✅ Student updated successfully.");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int studentId) {
        String sql = "DELETE FROM students WHERE student_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}