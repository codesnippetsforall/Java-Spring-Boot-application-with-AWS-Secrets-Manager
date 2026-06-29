package com.winsoon.student.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winsoon.student.dto.StudentRequest;
import com.winsoon.student.dto.StudentUpdateRequest;
import com.winsoon.student.model.Student;
import com.winsoon.student.service.StudentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> create(@Valid @RequestBody StudentRequest request) {
        Student created = studentService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{studentId}")
    public Student getById(@PathVariable String studentId) {
        return studentService.getById(studentId);
    }

    @PutMapping("/{studentId}")
    public Student update(
            @PathVariable String studentId,
            @RequestBody StudentUpdateRequest request) {
        return studentService.update(studentId, request);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable String studentId) {
        studentService.delete(studentId);
        return ResponseEntity.ok(Map.of(
                "message", "Student deleted successfully",
                "studentId", studentId));
    }
}
