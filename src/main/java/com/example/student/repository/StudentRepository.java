package com.example.student.repository;

import com.example.student.model.Student;
import com.example.student.model.StudentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, StudentId> {
}
