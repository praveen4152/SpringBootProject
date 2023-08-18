package com.praveen.repository;

import com.praveen.entity.Guardian;
import com.praveen.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailName("abc@123gmail.com")
                .firstName("Praveen")
                .lastName("Pandey")
                // .guardianName("premchand")
                // .guardianEmail("prem@123gmail.com")
                //.guardianMobile("6202066096")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .email("kgf@123gmail.com")
                .name("pandey")
                .mobile("9784541785")
                .build();


        Student student = Student.builder()
                .firstName("monu")
                .emailName("monu@123aA")
                .lastName("pandit")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students =
                studentRepository.findByFirstName("Praveen");

        System.out.println("students : " + students);
    }

    @Test
    public void printStudentByLastName() {
        List<Student> student1 =
                studentRepository.findByLastName("pandit");

        System.out.println("List of Students: " + student1);
    }

    @Test
    public void printStudentByGuardianName() {
        List<Student> guardian = studentRepository.findByGuardianName("premchand");
        System.out.println("guardian = " + guardian);
    }

    @Test
    void findByFirstNameAndLastName() {
        Student byFirstNameAndLastName = studentRepository.findByFirstNameAndLastName("Praveen", "pandey");
        System.out.println("byFirstNameAndLastName = " + byFirstNameAndLastName);
    }


    @Test
    void getStudentFirstNameByEmailName() {
        String studentFirstNameByEmailName = studentRepository.getStudentFirstNameByEmailName("monu@123aA");
        System.out.println("studentFirstNameByEmailName = " + studentFirstNameByEmailName);
    }


    @Test
    void getStudentByEmailNameAddressNative() {
        Student aNative = studentRepository.getStudentByEmailNameAddressNative("monu@123aA");
        System.out.println("aNative = " + aNative);
    }

    @Test
    void getStudentByEmailNameAddressNativeNameParam() {
        Student nameParam = studentRepository.getStudentByEmailNameAddressNativeNameParam("monu@123aA");
        System.out.println("nameParam = " + nameParam);

    }

    @Test
    void findByEmailName() {
        studentRepository.findByEmailName("monu@123gmail.com");
    }
}
