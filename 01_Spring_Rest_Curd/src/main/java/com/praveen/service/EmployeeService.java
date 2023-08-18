package com.praveen.service;

import java.util.List;

import com.praveen.entity.Employee;

public interface EmployeeService {
	Employee saveEmployeeData(Employee employee);

	List<Employee> getAllEmployeeData();

	Employee getEmployeeById(Long id);

	Employee updateEmployee(Employee employee, Long id);

	void deleteEmployee(Long id);
}
