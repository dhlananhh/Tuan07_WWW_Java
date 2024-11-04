package iuh.fit.se.springdatajpa.mappers;


import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import iuh.fit.se.springdatajpa.dto.EmployeeDTO;
import iuh.fit.se.springdatajpa.entities.Employee;


@Service
public class EmployeeMapper {

	public EmployeeDTO employeeToDTO (Employee employee) {
		EmployeeDTO mappedEmployeeRecord = new EmployeeDTO(
			employee.getEmpId(), 
			employee.getEmpName(), 
			employee.getDob(),
			employee.getDept().getDeptName()
		);
		
		return mappedEmployeeRecord;
	}
	
	
	public List<EmployeeDTO> employeeListToDTOList(List<Employee> employees) {
		List<EmployeeDTO> mappedEmployeeRecords = new ArrayList<EmployeeDTO>();
		for (Employee employee : employees) {
			EmployeeDTO mappedEmployeeRecord = new EmployeeDTO(
				employee.getEmpId(), 
				employee.getEmpName(),
				employee.getDob(), 
				employee.getDept().getDeptName()
			);
			mappedEmployeeRecords.add(mappedEmployeeRecord);
		}
		return mappedEmployeeRecords;
	}
}
