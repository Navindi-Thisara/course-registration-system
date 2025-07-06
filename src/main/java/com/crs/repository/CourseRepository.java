package com.crs.repository;

import com.crs.model.Course;
import com.crs.util.DBConnection;

import java.sql.*;
import java.util.List;

public class CourseRepository {

    public void addCourse(Course course) {
        String sql = "INSERT INTO courses (title, credit_hours, department, capacity) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, course.getTitle());
            stmt.setInt(2, course.getCreditHours());
            stmt.setString(3, course.getDepartment());
            stmt.setInt(4, course.getCapacity());

            stmt.executeUpdate();
            System.out.println("Course added successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Course> getAllCourses() {
        String sql = "SELECT * FROM courses";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt("course_id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("department") + " | " +
                        rs.getInt("credit_hours") + " | " +
                        rs.getInt("capacity"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Course getCourseById(int courseId) {
        String sql = "SELECT * FROM courses WHERE course_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, courseId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Course(
                            rs.getInt("course_id"),
                            rs.getString("title"),
                            rs.getInt("credit_hours"),
                            rs.getString("department"),
                            rs.getInt("capacity")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateCourse(Course course) {
        String sql = "UPDATE courses SET title = ?, credit_hours = ?, department = ?, capacity = ? WHERE course_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, course.getTitle());
            stmt.setInt(2, course.getCreditHours());
            stmt.setString(3, course.getDepartment());
            stmt.setInt(4, course.getCapacity());
            stmt.setInt(5, course.getCourseId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Course updated successfully.");
            } else {
                System.out.println("Course not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCourse(int courseId) {
        String sql = "DELETE FROM courses WHERE course_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, courseId);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Course deleted successfully.");
            } else {
                System.out.println("Course not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
