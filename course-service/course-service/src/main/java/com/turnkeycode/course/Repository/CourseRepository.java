package com.turnkeycode.course.Repository;

import com.turnkeycode.course.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository  extends JpaRepository<Courses,Integer> {
    Courses findByCourseId(Integer courseId);

   Courses deleteCourseById(Integer courseId);
}
