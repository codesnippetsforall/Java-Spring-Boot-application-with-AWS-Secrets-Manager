package com.winsoon.student.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String studentId) {
        super("Student not found with student_id=" + studentId);
    }
}
