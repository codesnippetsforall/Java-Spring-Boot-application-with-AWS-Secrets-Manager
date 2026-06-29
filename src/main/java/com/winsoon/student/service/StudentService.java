package com.winsoon.student.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.winsoon.student.dto.StudentRequest;
import com.winsoon.student.dto.StudentUpdateRequest;
import com.winsoon.student.exception.StudentNotFoundException;
import com.winsoon.student.model.Student;
import com.winsoon.student.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public Student create(StudentRequest request) {
        Student student = new Student();
        student.setStudentId(request.getStudentId());
        student.setStudentName(request.getStudentName());
        student.setEmail(request.getEmail());
        student.setCourse(request.getCourse());
        return studentRepository.save(student);
    }

    public Student getById(String studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Transactional
    public Student update(String studentId, StudentUpdateRequest request) {
        Student student = getById(studentId);
        if (request.getStudentName() != null) {
            student.setStudentName(request.getStudentName());
        }
        if (request.getEmail() != null) {
            student.setEmail(request.getEmail());
        }
        if (request.getCourse() != null) {
            student.setCourse(request.getCourse());
        }
        return studentRepository.save(student);
    }

    @Transactional
    public void delete(String studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new StudentNotFoundException(studentId);
        }
        studentRepository.deleteById(studentId);
    }
}
