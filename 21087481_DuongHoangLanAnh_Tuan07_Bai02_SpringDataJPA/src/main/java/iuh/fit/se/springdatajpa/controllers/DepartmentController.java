package iuh.fit.se.springdatajpa.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iuh.fit.se.springdatajpa.entities.Department;
import iuh.fit.se.springdatajpa.exceptions.ResourceNotFoundException;
import iuh.fit.se.springdatajpa.repositories.DepartmentRepository;


@RestController
@RequestMapping ("/api/v1")
public class DepartmentController {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	public DepartmentController (DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
	
	
	// Get all departments
	@GetMapping("/departments")
	public Iterable<Department> getAllDepartments() {
		return this.departmentRepository.findAll();
	}
	
	
	// Get department by id
	@GetMapping("/departments/{id}")
	public ResponseEntity<Department> getDepartmentById (
		@PathVariable(value = "id") Long departmentId
	) throws ResourceNotFoundException {
		Department department = this.departmentRepository.findById(departmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + departmentId));
		return ResponseEntity.ok().body(department);
	}
}
