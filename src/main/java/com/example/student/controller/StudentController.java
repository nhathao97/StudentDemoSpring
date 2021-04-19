package com.example.student.controller;

import com.example.student.domain.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudentById/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer studentId){
        return ResponseEntity.ok().body(studentService.getStudentById(studentId).orElse(null));
    }

    @GetMapping("/totalOfStudent")
    public ResponseEntity<Long> getTotalOfStudent(){
        return ResponseEntity.ok().body(studentService.getTotalStudent());
    }

    @GetMapping("/getPageStudent/{page}/{rowsPerPage}")
    public ResponseEntity<List<Student>> getPageStudent(@PathVariable Integer page,@PathVariable Integer rowsPerPage){
        Page<Student> studentPage = studentService.getPageStudent(PageRequest.of(page,rowsPerPage));
        return ResponseEntity.ok().body(studentPage.getContent());
    }

    @GetMapping("findStudent/{studentName}")
    public ResponseEntity<List<Student>> findStudent(@PathVariable String studentName){
        return ResponseEntity.ok().body(studentService.findAllStudent(studentName));
    }

    @PostMapping("/saveStudent")
    public ResponseEntity<String> saveStudent(@RequestBody Student student){
        student.setCreated_at(LocalDate.now());
        studentService.saveStudent(student);
        return ResponseEntity.ok().body("Success");
    }

    @DeleteMapping("/deleteStudent/{studentID}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer studentID){
        studentService.deleteStudentById(studentID);
        return ResponseEntity.ok().body("Success");
    }

}
