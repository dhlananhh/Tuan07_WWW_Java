package iuh.fit.se.annotationbased.dao;


import java.util.List;

import iuh.fit.se.annotationbased.entities.Employee;


public interface EmployeeDAO {
	void save(Employee employee);
    void update(Employee employee);
    Employee getById(int id);
    void deleteById(int id);
    List<Employee> getAll();
}
