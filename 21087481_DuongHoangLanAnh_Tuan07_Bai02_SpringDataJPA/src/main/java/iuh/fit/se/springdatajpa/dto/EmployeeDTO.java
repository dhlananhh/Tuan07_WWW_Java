package iuh.fit.se.springdatajpa.dto;

import java.util.Date;

public record EmployeeDTO (
	Long empId,
	String empName,
	Date dob,
	String deptName
){
    
}
