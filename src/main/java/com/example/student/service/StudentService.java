package com.example.student.service;

import com.example.student.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Optional<Student> getStudentById(Integer studentId);
    void saveStudent(Student student);
    Long getTotalStudent();
    Page<Student> getPageStudent(PageRequest pageRequest);
    void deleteStudentById(Integer studentId);
    List<Student> findAllStudent(String studentName);
}
