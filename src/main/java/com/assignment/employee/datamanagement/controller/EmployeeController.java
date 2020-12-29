package com.assignment.employee.datamanagement.controller;


import com.assignment.employee.datamanagement.model.Employee;
import com.assignment.employee.datamanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;



	// Select, Insert, Delete, Update Operations for an Employee

	@GetMapping(value = "/employee/{id}")
	public Employee getEmployee(@PathVariable long id){
		Employee  emp = new Employee();
		if(employeeRepository.findById(id).isPresent()) {
			  emp = employeeRepository.findById(id).get();
		}
		return emp;
	}

	@PostMapping(value = "/employee")
	public String addEmployee(@RequestBody Employee employee){
		 employeeRepository.save(employee);
		return "Success adding an employee ";
	}

	@PutMapping(value = "/employee")
	public Employee updateEmployee(@RequestBody Employee employee){
		Employee updatedEmployee = employeeRepository.save(employee);
		return updatedEmployee;
	}

	/*@DeleteMapping(value = "/employee")
	public Map<String, String> deleteEmployee(@RequestParam long id){
		Map<String, String> status = new HashMap<>();
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			employeeRepository.delete(employee.get());
			status.put("Status", "Employee deleted successfully");
		}
		else {
			status.put("Status", "Employee not exist");
		}
		return status;
	}*/

	@DeleteMapping(value = "/deleteEmployee/{id}", headers = "Accept=application/json")
	public Map<String, String> deleteEmployee(@PathVariable("id") long id) {
		Map<String, String> status = new HashMap<>();
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			employeeRepository.delete(employee.get());
			status.put("Status", "Employee deleted successfully");
		}
		else {
			status.put("Status", "Employee not exist");
		}
		return status;
	}

	// Select, Insert, Delete for List of Employees

	@GetMapping(value = "/employees")
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}

	@PostMapping(value = "/employees")
	public String addAllEmployees(@RequestBody List<Employee> employeeList){
		employeeRepository.saveAll(employeeList);
		return "Success adding employees";
	}

	@DeleteMapping(value = "/employees")
	public String addAllEmployees(){
		employeeRepository.deleteAll();
		return "SUCCESS";
	}


}
