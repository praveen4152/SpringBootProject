package com.praveen.service;

import java.util.List;

import com.praveen.entity.Student;

public interface StudentService {
	Student saveStudentData(Student student);

	List<Student> getAllStudent();

	Student getStudentById(Integer id);
	
	Student updateStudent(Student student , Integer id);
	
	void deleteStudent(Integer id);
}
