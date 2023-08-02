package com.turnkeycode.students.Controller;


import com.turnkeycode.students.Entity.Student;
import com.turnkeycode.students.Service.Impl.StudentServiceImpl;
import com.turnkeycode.students.VO.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    //API to register student//

    @PostMapping("/registerStudent")
    public Student saveStudent(@RequestBody Student student){
        log.info("Inside the save student of save controller");
        return studentServiceImpl.saveStudent(student);
    }

    //API to get all the list of students//
    @GetMapping("/getStudents")
    public List<Student> findAllStudents(Student student){
        return studentServiceImpl.findAll(student);
    }

    //API to get the student with course using id//
    @GetMapping("/getStudentWithCourse/{id}")
    public ResponseTemplateVO getStudentWithCourse(@PathVariable("id") Integer studentId){
        return studentServiceImpl.getStudentWithCourse(studentId);
    }

    //API to allocate student with course and saving in db//
    @PostMapping("/addStudentToCourse")
    public ResponseTemplateVO addStudentToCourse(@RequestBody Student student){
        return studentServiceImpl.saveStudentToCourse(student);
    }

    //API to update courses for one student//
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable("id") Integer studentId,@RequestBody Student student){
        return studentServiceImpl.updateStudent(studentId,student);
    }

    //API to get all students with selected courses//

    @GetMapping("/studentwithselectedcourse")
    public List<Student> getAllStudentsWithSelectedCourses() {
        return studentServiceImpl.getAllStudentsWithSelectedCourses();
    }

    //API to delete student//

//    @DeleteMapping("/deleteCourse/{id}")
//    public Student deleteCourse(@PathVariable("id") Integer studentId){
//        return  studentServiceImpl.deleteStudent(studentId);
//    }

}
