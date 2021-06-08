package com.example.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;

import antlr.collections.List;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	public Employee saveEmployee(Employee emp) {
		return repository.save(emp);
	}
	
	public java.util.List<Employee> getAllEmployees() {
		return repository.findAll();
	}
}
