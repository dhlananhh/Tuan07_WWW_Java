package iuh.fit.se.springdatajpa.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;

import iuh.fit.se.springdatajpa.mappers.DepartmentMapper;
import iuh.fit.se.springdatajpa.repositories.DepartmentRepository;


public class DepartmentServiceImpl {

	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	DepartmentRepository departmentRepository;
}
