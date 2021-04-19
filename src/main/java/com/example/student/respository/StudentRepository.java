package com.example.student.respository;

import com.example.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT s FROM Student s WHERE s.name LIKE %?1% " +
            "OR s.address LIKE %?1%" +
            "OR s.gender LIKE %?1%" +
            "OR s.studentID LIKE %?1%")
    List<Student> findAll(String studentName);
}
