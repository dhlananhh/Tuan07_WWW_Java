package iuh.fit.se.springdatajpa.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iuh.fit.se.springdatajpa.dto.EmployeeDTO;
import iuh.fit.se.springdatajpa.entities.Employee;
import iuh.fit.se.springdatajpa.exceptions.ResourceNotFoundException;
import iuh.fit.se.springdatajpa.repositories.DepartmentRepository;
import iuh.fit.se.springdatajpa.repositories.EmployeeRepository;
import iuh.fit.se.springdatajpa.serviceImpl.EmployeeServiceImpl;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
//	@Autowired
//	EmployeeServiceImpl employeeServiceImpl;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	
//	public DepartmentController (DepartmentRepository departmentRepository) {
//		this.departmentRepository = departmentRepository;
//	}
	
	
	public EmployeeController (EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	
	// Get all employees
	@GetMapping
	public List<Employee> getAllEmployees() {
		return this.employeeRepository.findAll();
	}
	
	
	// Get employee by id
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById (
		@PathVariable(value = "id") Long employeeId
	) throws ResourceNotFoundException {
		Employee employee = this.employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("No employees found for this ID: " + employeeId));
		
		return ResponseEntity.ok().body(employee);
	}
	
	
	/**
	 * Create a new employee
	 * @param employee
	 * @return
	 */
	@PostMapping
	public Employee createEmployee (
		@Valid @RequestBody Employee employee
	) {
		return this.employeeRepository.save(employee);
	}
	
	
	/**
	 * Update an existing employee
	 * @param employeeId
	 * @param employeeDetails
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee (
		@PathVariable(value = "id") Long employeeId,
		@Valid @RequestBody Employee employeeDetails
	) throws ResourceNotFoundException {
		// check if id exists or not
		Employee employee = this.employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("No employees found for this ID: " + employeeId));
		
		// if the employeeId exists
		// then update new information 
		employee.setEmpName(employeeDetails.getEmpName());
		employee.setDob(employeeDetails.getDob());
		employee.setDept(employeeDetails.getDept());
		
		// 
		final Employee updatedEmployee = this.employeeRepository.save(employee);
		
		return ResponseEntity.ok(updatedEmployee);
	}
	
	
	/**
	 * Delete employee by id
	 * @param employeeId
	 * @return
	 * @throws ResourceNotFoundException - if employeeId not exists
	 */
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteEmployee (
		@PathVariable(value = "id") Long employeeId
	) throws ResourceNotFoundException {
		// check if employeeId exists or not
		Employee employee = this.employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("No employees found for this ID: " + employeeId));
		
		// if employeeId exists
		// then delete that employee
		employeeRepository.delete(employee);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
}
