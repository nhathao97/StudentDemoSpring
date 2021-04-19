package com.example.student.service.serviceIml;

import com.example.student.domain.Student;
import com.example.student.respository.StudentRepository;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceIml implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Optional<Student> getStudentById(Integer studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Long getTotalStudent() {
        return studentRepository.count();
    }

    @Override
    public Page<Student> getPageStudent(PageRequest pageRequest) {
        return studentRepository.findAll(pageRequest);
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> findAllStudent(String studentName) {
        return studentRepository.findAll(studentName);
    }

}
