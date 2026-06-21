package com.example.student.service;

import com.example.student.dto.StudentRequest;
import com.example.student.dto.StudentUpdateRequest;
import com.example.student.exception.StudentNotFoundException;
import com.example.student.model.Student;
import com.example.student.model.StudentId;
import com.example.student.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Student getById(String studentId, String studentName) {
        return studentRepository.findById(new StudentId(studentId, studentName))
                .orElseThrow(() -> new StudentNotFoundException(studentId, studentName));
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Transactional
    public Student update(String studentId, String studentName, StudentUpdateRequest request) {
        Student student = getById(studentId, studentName);
        if (request.getEmail() != null) {
            student.setEmail(request.getEmail());
        }
        if (request.getCourse() != null) {
            student.setCourse(request.getCourse());
        }
        return studentRepository.save(student);
    }

    @Transactional
    public void delete(String studentId, String studentName) {
        StudentId id = new StudentId(studentId, studentName);
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException(studentId, studentName);
        }
        studentRepository.deleteById(id);
    }
}
