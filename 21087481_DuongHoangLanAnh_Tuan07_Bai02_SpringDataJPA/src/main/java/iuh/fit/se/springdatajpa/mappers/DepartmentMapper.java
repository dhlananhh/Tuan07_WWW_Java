package iuh.fit.se.springdatajpa.mappers;

import iuh.fit.se.springdatajpa.dto.DepartmentDTO;
import iuh.fit.se.springdatajpa.entities.Department;

public class DepartmentMapper {
	
	public DepartmentDTO departmenttoDTO (Department department) {
		DepartmentDTO mappedDepartmentRecord = new DepartmentDTO(
			department.getDeptId(), 
			department.getDeptName()
		);
		
		return mappedDepartmentRecord;
	}
	
}
