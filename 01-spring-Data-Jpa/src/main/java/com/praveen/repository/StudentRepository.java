package com.praveen.repository;

import com.praveen.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
     List<Student> findByFirstName(String firstName);
     List<Student> findByLastName(String lastName);

     List<Student> findByEmailName(String emailName);

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName , String lastName);

    //1.JPQL
    @Query("select s.firstName from Student s where s.emailName =?1")
    String getStudentFirstNameByEmailName(String emailName);

    //2.Native Query
    @Query(
            value = "select * from tbl_student s where s.email_address =?1",
            nativeQuery = true
    )
    Student getStudentByEmailNameAddressNative(String emailName);

    //3.Native Named Param
    @Query(
            value = "select * from tbl_student s where s.email_address =?1",
            nativeQuery = true
    )
    Student getStudentByEmailNameAddressNativeNameParam(
            @Param("emailName") String emailName
    );

}