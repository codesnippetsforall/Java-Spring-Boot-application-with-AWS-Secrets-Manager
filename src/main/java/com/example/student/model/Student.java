package com.example.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
@IdClass(StudentId.class)
public class Student {

    @Id
    @Column(name = "student_id", nullable = false, length = 50)
    private String studentId;

    @Id
    @Column(name = "student_name", nullable = false, length = 100)
    private String studentName;

    @Column(length = 255)
    private String email;

    @Column(length = 100)
    private String course;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
