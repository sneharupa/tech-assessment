package com.turnkeycode.course.Service.Impl;

import com.turnkeycode.course.Entity.Courses;
import com.turnkeycode.course.Repository.CourseRepository;
import com.turnkeycode.course.Service.CoursesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CoursesServiceImpl implements CoursesService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Courses saveCourse(Courses courses) {
        log.info("Inside the save method of course service ");
        return courseRepository.save(courses);
    }

    @Override
    public Courses findByCourseId(Integer courseId) {
        return courseRepository.findByCourseId(courseId);
    }

    @Override
    public List<Courses> findAll(Courses courses) {
        return courseRepository.findAll();
    }

    @Override
    public Courses updateCourse(Integer courseId,Courses courses) {

        Courses getCourse;
        getCourse = courseRepository.getById(courseId);
        getCourse.setCourseName(courses.getCourseName());
        getCourse.setCourseCode(courses.getCourseCode());
        Courses updateCourseData=courseRepository.save(getCourse);
        return updateCourseData;
    }

      @Override
    public Courses deleteCourse(Integer courseId){
        return courseRepository.deleteCourseById(courseId);
    }
}
