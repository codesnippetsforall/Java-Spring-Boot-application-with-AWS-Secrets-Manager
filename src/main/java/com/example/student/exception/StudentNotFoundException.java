package com.example.student.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String studentId, String studentName) {
        super("Student not found with student_id=" + studentId + " and student_name=" + studentName);
    }
}
