package iuh.fit.se.xmlbased;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import iuh.fit.se.xmlbased.dao.EmployeeDAO;
import iuh.fit.se.xmlbased.entities.Employee;


public class SpringPureJdbcXmlConfigApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("databaseConfig.xml");
		
		EmployeeDAO employeeDAO = context.getBean(EmployeeDAO.class);
		
		Employee employee = new Employee();
		employee.setName("John Doe");
		employee.setRole("Software Engineer");
		employee.setSalary(50000);
		
		employeeDAO.save(employee);
		
		System.out.println("Employee saved successfully");
	}

}
