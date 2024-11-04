package iuh.fit.se.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import iuh.fit.se.springboot.dao.EmployeeDAO;
import iuh.fit.se.springboot.entities.Employee;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {
	@Autowired
    private EmployeeDAO employeeDAO;
	
	
	public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcApplication.class, args);
    }


	@Override
	public void run(String... args) throws Exception {
        // Test CRUD operations
        Employee employee = new Employee();
        employee.setId(3);
        employee.setName("Jeremy Lawrence");
        employee.setRole("Software Architect");
        employee.setSalary(70000);
        employeeDAO.save(employee);
        System.out.println("Employee saved successfully!");
        System.out.println("Employee saved: " + employee);
	}
}
