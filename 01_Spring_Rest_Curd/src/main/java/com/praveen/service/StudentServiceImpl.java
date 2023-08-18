package com.praveen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.entity.Student;
import com.praveen.exception.ResourceNotFoundException;
import com.praveen.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudentData(Student student) {

		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Integer id) {
		Optional<Student> findById = studentRepository.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		} else {
			throw new ResourceNotFoundException("Student", "Id", id);
		}

	}

	@Override
	public Student updateStudent(Student student, Integer id) {
       Student existingStudent = studentRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Student", "Id", id));
       existingStudent.setEmail(student.getEmail());
       existingStudent.setFirstName(student.getFirstName());
       existingStudent.setLastName(student.getLastName());
       
       return existingStudent;
       
	}

	@Override
	public void deleteStudent(Integer id) {
		studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));
      studentRepository.deleteById(id);	
	}

}
