package com.praveen.repository;

import com.praveen.entity.Course;
import com.praveen.entity.CourseMaster;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMasterRepositoryTest {
    @Autowired
    CourseMasterRepository courseMasterRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Test
    void saveCourseMaterial(){
        Course course =Course.builder()
                .title(".net")
                .credit(5)
                .build();

        CourseMaster courseMaster = CourseMaster
                                    .builder()
                                    .url("www.dailybuffer.com")
                                    .course(course)
                                    .build();
        courseMasterRepository.save(courseMaster);
    }

    @Test
     void printAllCourseMaster(){
        List<CourseMaster> courseMasters = courseMasterRepository.findAll();
        System.out.println("courseMasters = " + courseMasters);
    }
}