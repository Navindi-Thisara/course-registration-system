package com.crs.model;

public class Student {
    private int studentId;
    private String name;
    private String dob;
    private String program;
    private int year;
    private String contactInfo;
    private int userId;

    public Student() {}

    public Student(int studentId, String name, String dob, String program, int year, String contactInfo, int userId) {
        this.studentId = studentId;
        this.name = name;
        this.dob = dob;
        this.program = program;
        this.year = year;
        this.contactInfo = contactInfo;
        this.userId = userId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getProgram() {
        return program;
    }

    public int getYear() {
        return year;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public int getUserId() {
        return userId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", name='" + name + '\'' + ", dob='" + dob + '\'' + ", program='" + program + '\'' + ", year=" + year + ", contactInfo='" + contactInfo + '\'' + ", userId=" + userId + '}';
    }

}


