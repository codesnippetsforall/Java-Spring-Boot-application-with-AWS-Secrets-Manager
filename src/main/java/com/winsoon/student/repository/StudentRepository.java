package com.winsoon.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.winsoon.student.model.Student;
import com.winsoon.student.model.StudentId;

public interface StudentRepository extends JpaRepository<Student, StudentId> {
}
