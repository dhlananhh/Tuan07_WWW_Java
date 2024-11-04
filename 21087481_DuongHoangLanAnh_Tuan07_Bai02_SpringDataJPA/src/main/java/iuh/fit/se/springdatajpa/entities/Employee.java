package iuh.fit.se.springdatajpa.entities;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table (name = "employee")
public class Employee {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "emp_id")
	private Long empId;
	
	@Column (name = "emp_name", nullable = false, length = 150)
	private String empName;
	
	@Column (name = "dob")
	private Date dob;
	
	@JsonIgnore
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "dept_id")
	private Department dept;
	
	
	public Employee() {
		super();
	}

	public Employee(String empName, Date dob, Department dept) {
        this.empName = empName;
        this.dob = dob;
        this.dept = dept;
    }
	
	
	public Employee(Long empId, String empName, Date dob, Department dept) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.dob = dob;
		this.dept = dept;
	}


	public Long getEmpId() {
		return empId;
	}


	public void setEmpId(Long empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public Department getDept() {
		return dept;
	}


	public void setDept(Department dept) {
		this.dept = dept;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", dob=" + dob + ", dept=" + dept + "]";
	}
	
}
