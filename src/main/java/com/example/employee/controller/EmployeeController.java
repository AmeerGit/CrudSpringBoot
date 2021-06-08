package com.example.employee.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.entity.Employee;
import com.example.employee.repository.AddressRepository;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;


@CrossOrigin
@RestController
@RequestMapping
public class EmployeeController {
     
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private AddressRepository address;
	
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		Employee emp1 = repository.save(emp);
		return new ResponseEntity<>(emp1, HttpStatus.OK);
	}
	
	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> emplist = repository.findAll();
		
		return new ResponseEntity<>(emplist , HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp, @PathVariable Integer id){
		
		Optional<Employee> empData = repository.findById(id);
		if(empData.isPresent()) {
			
			Employee emp1 = empData.get();
			emp1.setEmployeeId(emp.getEmployeeId());
			emp1.setEmployeeName(emp.getEmployeeName());
			emp1.setSalary(emp.getSalary());
			emp1.setAddress(emp.getAddress());
			return new ResponseEntity<Employee>(repository.save(emp1), HttpStatus.OK);
		}else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
		try {
			repository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
