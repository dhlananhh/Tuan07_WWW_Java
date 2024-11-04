package iuh.fit.se.xmlbased.daoImpl;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import iuh.fit.se.xmlbased.dao.EmployeeDAO;
import iuh.fit.se.xmlbased.entities.Employee;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	private JdbcTemplate jdbcTemplate;
	

	@Autowired
    public void setDataSource (DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


	@Override
	public void save (Employee employee) {
		String sql = "INSERT INTO employee (name, role, salary) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, employee.getName(), employee.getRole(), employee.getSalary());
	}


	@Override
	public void update (Employee employee) {
		String sql = "UPDATE employee SET name = ?, role = ?, salary = ? WHERE id = ?";
		jdbcTemplate.update(sql, employee.getName(), employee.getRole(), employee.getSalary(), employee.getId());
	}


	@Override
	public Employee getById (int id) {
		String sql = "SELECT * FROM employee WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class), id);
	}


	@Override
	public void deleteById (int id) {
	    String sql = "DELETE FROM employee WHERE id = ?";
        jdbcTemplate.update(sql, id);
	}


	@Override
	public List<Employee> getAll() {
		String sql = "SELECT * FROM employee";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
	}
}
