package iuh.fit.se.springdatajpa.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import iuh.fit.se.springdatajpa.entities.Employee;


@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}