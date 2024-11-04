package iuh.fit.se.springdatajpa.services;

import java.util.List;
import java.util.stream.Collectors;

import iuh.fit.se.springdatajpa.dto.EmployeeDTO;
import iuh.fit.se.springdatajpa.repositories.EmployeeRepository;

public interface EmployeeService {
	public static final EmployeeRepository employeeRepository = null;
	
	
	public static List<EmployeeDTO> findAllEmployees() {
		List<EmployeeDTO> listEmployees = employeeRepository.findAll()
				.stream()
				.map(employee -> new EmployeeDTO(
						employee.getEmpId(), 
						employee.getEmpName(),
						employee.getDob(), 
						employee.getDept().getDeptName()
					))
				.collect(Collectors.toList());
		
		return listEmployees;
	}
}
