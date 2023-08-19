package com.praveen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.praveen.entity.Student;
import com.praveen.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public String getAllStudent(Model model) {
		model.addAttribute("students", studentService.getAllStudent());
		return "index";
		
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute Student student ) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
     public String getStudentById(@PathVariable Long id ,Model model) {
    	 model.addAttribute("student", studentService.getStudentById(id));
    	 return "edit_students";
     }
	
	  @PostMapping("/students/{id}")
	    public String updateStudentForm(@PathVariable Long id , @ModelAttribute Student student ,Model model) {
	        Student existingStudent = studentService.getStudentById(id);
	        //existingStudent.setId(id);
	        existingStudent.setFirstName(student.getFirstName());
	        existingStudent.setLastname(student.getLastname());
	        existingStudent.setEmail(student.getEmail());

	        studentService.updateStudent(existingStudent);

	        return "redirect:/students";

	    }
}
