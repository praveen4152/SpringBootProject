package com.praveen.repository;

import com.praveen.entity.Course;
import com.praveen.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void printCourse(){

        List<Course> courseList =
                courseRepository.findAll();
        System.out.println("courseList = " + courseList);
    }

    @Test
    void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Honey")
                .lastName("Singh")
                .build();
        Course  course = Course.builder()
                .credit(8)
                .title("Sql")
                .teacher(teacher)
                .build();
        courseRepository.save(course);

    }



}