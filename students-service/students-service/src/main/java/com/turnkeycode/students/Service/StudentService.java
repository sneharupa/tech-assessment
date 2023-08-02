package com.turnkeycode.students.Service;


import com.turnkeycode.students.Entity.Student;
import com.turnkeycode.students.VO.ResponseTemplateVO;

import java.util.List;


public interface StudentService  {

    public Student saveStudent(Student student) ;

    public ResponseTemplateVO getStudentWithCourse(Integer studentId) ;
    public List<Student> findAll(Student student);

    Student updateStudent(Integer studentId, Student student);

    ResponseTemplateVO saveStudentToCourse(Student student);

     List<Student> getAllStudentsWithSelectedCourses();


    Student deleteStudent(Integer studentId);



}
