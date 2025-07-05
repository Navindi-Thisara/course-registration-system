package com.crs.model;

public class Course {
    private int courseId;
    private String title;
    private int creditHours;
    private String department;
    private int capacity;

    public Course() {}

    public Course(int courseId, String title, int creditHours, String department, int capacity) {
        this.courseId = courseId;
        this.title = title;
        this.creditHours = creditHours;
        this.department = department;
        this.capacity = capacity;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Course{" + "courseId=" + courseId + ", title='" + title + '\'' + ", creditHours=" + creditHours + ", department='" + department + '\'' + ", capacity=" + capacity + '}';
    }

}
