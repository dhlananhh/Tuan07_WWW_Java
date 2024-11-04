package iuh.fit.se.springdatajpa.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.fit.se.springdatajpa.dto.EmployeeDTO;
import iuh.fit.se.springdatajpa.entities.Employee;
import iuh.fit.se.springdatajpa.mappers.EmployeeMapper;
import iuh.fit.se.springdatajpa.repositories.EmployeeRepository;
import iuh.fit.se.springdatajpa.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	EmployeeRepository employeeRepository;

	
	// Get all employees
	public List<EmployeeDTO> findAllEmployees() {
		List<Employee> listEmployees = employeeRepository.findAll();
		return employeeMapper.employeeListToDTOList(listEmployees);
	}

	
	// Get employee by id
	public EmployeeDTO findEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id).get();
		return employeeMapper.employeeToDTO(employee);
	}
}
