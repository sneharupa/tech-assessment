package com.turnkeycode.course.Controller;

import com.turnkeycode.course.Entity.Courses;
import com.turnkeycode.course.Repository.CourseRepository;
import com.turnkeycode.course.Service.CoursesService;
import com.turnkeycode.course.Service.Impl.CoursesServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@Slf4j
public class CourseController {
    @Autowired
    private CoursesServiceImpl coursesServiceImpl;

    @Autowired
    private CourseRepository courseRepository;

    //API to add course//

    @PostMapping("/addCourse")
    public Courses saveCourse(@RequestBody Courses courses){
        log.info("Inside save course method of course controller");
        return coursesServiceImpl.saveCourse(courses);

    }

    // API to get course using id//

    @GetMapping("/{id}")
    public Courses findByCousrseId(@PathVariable("id") Integer courseId){
        return coursesServiceImpl.findByCourseId(courseId);
    }

    // API to get all List of courses and view all courses//

    @GetMapping("/getCourses")
    public List<Courses> findAllCourses(Courses courses){
        return coursesServiceImpl.findAll(courses);
    }

    //API to update course//

    @PutMapping("/{id}")
    public Courses updateCourse(@PathVariable("id") Integer courseId,@RequestBody Courses courses){
        return coursesServiceImpl.updateCourse(courseId,courses);
    }

     //API to delete course//

    @DeleteMapping("/deleteCourse/{id}")
    public Courses deleteCourse(@PathVariable("id") Integer courseId){
        return  coursesServiceImpl.deleteCourse(courseId);
    }
}
