package com.praveen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.entity.Student;
import com.praveen.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/saveStudents")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.saveStudentData(student) ,HttpStatus.CREATED);
	}
    
	@GetMapping("/getStudentsData")
	public List<Student> getAllStudent(){
		return studentService.getAllStudent();
	}
	
	@GetMapping("/getStudentsData/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
		return new ResponseEntity<Student>(studentService.getStudentById(id),HttpStatus.OK);
	}
	
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<Student> updateStudentById(@PathVariable Integer id , @RequestBody Student student){
		return new ResponseEntity<Student>(studentService.updateStudent(student, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Student Record Deleted Successfully", HttpStatus.OK);
	}
	
}
