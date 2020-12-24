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

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	Employee getEmployee(@PathVariable long id){
		return  employeeRepository.findById(id).get();
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	String addEmployee(@RequestBody Employee employee){
		Employee savedEmployee = employeeRepository.save(employee);
		return "SUCCESS";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
	Employee updateEmployee(@RequestBody Employee employee){
		Employee updatedEmployee = employeeRepository.save(employee);
		return updatedEmployee;
	}

	@RequestMapping(value = "/employee", method = RequestMethod.DELETE)
	Map<String, String> deleteEmployee(@RequestParam long id){
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

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}

	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	String addAllEmployees(@RequestBody List<Employee> employeeList){
		employeeRepository.saveAll(employeeList);
		return "SUCCESS";
	}

	@RequestMapping(value = "/employees", method = RequestMethod.DELETE)
	String addAllEmployees(){
		employeeRepository.deleteAll();
		return "SUCCESS";
	}
}
