package iuh.fit.se.annotationbased.entities;


public class Employee {
	private int id;
    private String name;
    private String role;
    private double salary;
    
    
    public Employee() {
    	
    }


	public Employee(int id, String name, String role, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.salary = salary;
	}


	public Employee(String name, String role, double salary) {
		super();
		this.name = name;
		this.role = role;
		this.salary = salary;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", salary=" + salary + "]";
	}
    
}
