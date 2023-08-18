package com.praveen.repository;

import com.praveen.entity.Course;
import com.praveen.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacherRecord(){
        Course course = Course.builder()
                       .title("DBA")
                        .credit(7)
                        .build();

        Course course1 = Course.builder()
                .title("JAVA")
                .credit(4)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Ramesh")
                .lastName("radhe")
              //  .courses(List.of(course ,course1))
                         .build();

        teacherRepository.save(teacher);

    }

}