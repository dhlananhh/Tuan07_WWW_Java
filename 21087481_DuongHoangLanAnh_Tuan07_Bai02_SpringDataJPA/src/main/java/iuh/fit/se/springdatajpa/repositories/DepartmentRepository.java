package iuh.fit.se.springdatajpa.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iuh.fit.se.springdatajpa.entities.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
}