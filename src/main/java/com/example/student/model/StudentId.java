package com.example.student.model;

import java.io.Serializable;
import java.util.Objects;

public class StudentId implements Serializable {

    private String studentId;
    private String studentName;

    public StudentId() {
    }

    public StudentId(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentId studentId1 = (StudentId) o;
        return Objects.equals(studentId, studentId1.studentId)
                && Objects.equals(studentName, studentId1.studentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studentName);
    }
}
