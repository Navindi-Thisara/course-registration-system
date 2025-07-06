package com.crs.controller;

import com.crs.model.Student;
import com.crs.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class StudentController {

    private final StudentService studentService = new StudentService();
    private final Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter DOB (YYYY-MM-DD): ");
        String dob = scanner.nextLine();
        System.out.print("Enter Program: ");
        String program = scanner.nextLine();
        System.out.print("Enter Year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Contact Info: ");
        String contact = scanner.nextLine();
        System.out.print("Enter User ID: ");
        int userId = Integer.parseInt(scanner.nextLine());

        Student student = new Student(0, name, dob, program, year, contact, userId);
        if (studentService.addStudent(student)) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Failed to add student.");
        }
    }

    public void listStudents() {
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
            System.out.println(s.getStudentId() + " | " + s.getName() + " | " + s.getProgram());
        }
    }

    public void updateStudent() {
        System.out.print("Enter Student ID to Update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student student = studentService.getStudentById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("New Name [" + student.getName() + "]: ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) student.setName(name);

        System.out.print("New DOB [" + student.getDob() + "]: ");
        String dob = scanner.nextLine();
        if (!dob.isEmpty()) student.setDob(dob);

        System.out.print("New Program [" + student.getProgram() + "]: ");
        String program = scanner.nextLine();
        if (!program.isEmpty()) student.setProgram(program);

        System.out.print("New Year [" + student.getYear() + "]: ");
        String yearInput = scanner.nextLine();
        if (!yearInput.isEmpty()) student.setYear(Integer.parseInt(yearInput));

        System.out.print("New Contact Info [" + student.getContactInfo() + "]: ");
        String contact = scanner.nextLine();
        if (!contact.isEmpty()) student.setContactInfo(contact);

        System.out.print("New User ID [" + student.getUserId() + "]: ");
        String userIdInput = scanner.nextLine();
        if (!userIdInput.isEmpty()) student.setUserId(Integer.parseInt(userIdInput));

        if (studentService.updateStudent(student)) {
            System.out.println("Student updated.");
        } else {
            System.out.println("Update failed.");
        }
    }

    public void deleteStudent() {
        System.out.print("Enter Student ID to Delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (studentService.deleteStudent(id)) {
            System.out.println("Student deleted.");
        } else {
            System.out.println("Delete failed.");
        }
    }
}
