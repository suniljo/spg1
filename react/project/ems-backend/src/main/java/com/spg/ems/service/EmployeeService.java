package com.spg.ems.service;

import java.util.List;

import com.spg.ems.entity.Employee;

public interface EmployeeService {
	 Integer saveEmployee(Employee emp);
	 
	 List<Employee> getAllEmployees();
	 
	 Employee getEmployeeById(Integer id);
	 
	 void deleteEmployeeById(Integer id);
}
