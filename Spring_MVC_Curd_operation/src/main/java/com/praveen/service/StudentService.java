package com.praveen.service;

import java.util.List;

import com.praveen.entity.Student;

public interface StudentService {
	List<Student> getAllStudent();

	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	 Student updateStudent(Student student);
}
