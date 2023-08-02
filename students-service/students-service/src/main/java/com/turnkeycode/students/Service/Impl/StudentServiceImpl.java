package com.turnkeycode.students.Service.Impl;


import com.turnkeycode.students.Entity.Student;
import com.turnkeycode.students.Repository.StudentRepository;
import com.turnkeycode.students.Service.StudentService;
import com.turnkeycode.students.VO.Course;
import com.turnkeycode.students.VO.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Student saveStudent(Student student) {
        log.info("Inside saveStudent of studentService");
        return studentRepository.save(student);
    }

    @Override
    public ResponseTemplateVO getStudentWithCourse(Integer studentId) {

        ResponseTemplateVO vo=new ResponseTemplateVO();
        Student student= studentRepository.findByStudentId(studentId);

        Course course=restTemplate.getForObject("http://localhost:9001/courses/"+student.getCourseId()
                ,Course.class);
        vo.setStudent(student);
        vo.setCourse(course);

        return vo;

    }

    @Override
    public List<Student> findAll(Student student) {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Integer studentId,Student student) {

        Student getStudent;
        getStudent = studentRepository.getById(studentId);
        getStudent.setFullName(student.getFullName());
        getStudent.setEmail(student.getEmail());
        getStudent.setPhoneNumber(student.getPhoneNumber());
        getStudent.setAddress(student.getAddress());
        Student updateStudentData=studentRepository.save(getStudent);
        return updateStudentData;
    }

    @Override
    public ResponseTemplateVO saveStudentToCourse(Student student){
        ResponseTemplateVO vo=new ResponseTemplateVO();
        Student student1= studentRepository.save(student);

        Course course=restTemplate.getForObject("http://localhost:9001/courses/"+student1.getCourseId()
                ,Course.class);
        vo.setStudent(student);
        vo.setCourse(course);

        return vo;


    }

    @Override
    public List<Student> getAllStudentsWithSelectedCourses(){
        return studentRepository.findAll();
    }


//      @Override
//    public Student deleteStudent(Integer studentId){
//        return studentRepository.deleteStudentById(studentId);
//    }


}
