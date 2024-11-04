package iuh.fit.se.annotationbased;


import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import iuh.fit.se.annotationbased.config.AppConfig;
import iuh.fit.se.annotationbased.dao.EmployeeDAO;
import iuh.fit.se.annotationbased.entities.Employee;


@SpringBootApplication
@ComponentScan (basePackages = {"iuh.fit.se.annotationbased.dao", "iuh.fit.se.annotationbased.daoImpl"})
@PropertySource ("classpath:database.properties")
public class SpringJdbcAnnotationBasedApplication {
	public static void main(String[] args) throws SQLException {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        EmployeeDAO employeeDAO = context.getBean(EmployeeDAO.class);
		
        // Test CRUD operations
        Employee employee = new Employee();
        employee.setId(5);
        employee.setName("Amelia Cruz");
        employee.setRole("Data Scientist");
        employee.setSalary(10000);
        employeeDAO.save(employee);
        System.out.println("Employee saved successfully!");
        System.out.println("Employee saved: " + employee);
	}

}
