package com.turnkeycode.students.Repository;

import com.turnkeycode.students.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findByStudentId(Integer studentId);

   // Student deleteStudentById(Integer studentId);
}
