package com.turnkeycode.course.Service;

import com.turnkeycode.course.Entity.Courses;
import com.turnkeycode.course.Repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public interface CoursesService {

    public Courses saveCourse(Courses courses);

    public Courses findByCourseId(Integer courseId) ;

    public List<Courses> findAll(Courses courses) ;

    public Courses updateCourse(Integer courseId,Courses courses) ;


     public Courses deleteCourse(Integer courseId);
}
