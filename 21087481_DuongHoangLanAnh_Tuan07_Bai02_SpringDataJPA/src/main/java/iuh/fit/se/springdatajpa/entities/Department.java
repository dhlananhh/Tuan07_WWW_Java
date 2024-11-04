package iuh.fit.se.springdatajpa.entities;


import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table (name = "department")
public class Department {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "dept_id")
	private Long deptId;
	
	@Column (name = "dept_name", unique = true, nullable = false, length = 150)
	private String deptName;
	
	
	// Cách này sẽ ngăn Jackson serialize thuộc tính employees khi trả về JSON của Department
	// do đó sẽ tránh được vòng lặp vô tận.
	@JsonIgnore
	// Cấu hình cascade = CascadeType.ALL và orphanRemoval = true trong Department entity 
	// là để khi lưu Department, các Employee liên quan cũng sẽ được lưu hoặc xóa tự động
	@OneToMany (mappedBy = "dept", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<Employee> employees;
	
	
	public Department() {
		super();
	}

	public Department(String deptName) {
        this.deptName = deptName;
    }
	
	
	public Department(Long deptId, String deptName, Set<Employee> employees) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.employees = employees;
	}


	public Long getDeptId() {
		return deptId;
	}


	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public Set<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}


	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", employees=" + employees + "]";
	}
	
}
