package com.winsoon.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student {

    @Id
    @Column(name = "student_id", nullable = false, length = 50)
    private String studentId;

    @Column(name = "student_name", nullable = false, length = 100)
    private String studentName;

    @Column(length = 255)
    private String email;

    @Column(length = 100)
    private String course;
}
