package entity;

public class Department {
	String department_id;
	String department_name;
	
	public Department() {
		super();
	}
	
	public Department(String department_id,String department_name){
		super();
		this.department_id = department_id;
		this.department_name = department_name;
	}
	
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
}
