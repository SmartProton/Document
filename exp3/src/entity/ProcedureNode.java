package entity;

import java.util.ArrayList;

public class ProcedureNode {
	String step;//�ڵ����
	String auth_id;//Ȩ��id��ͨ��Ȩ���ҵ���������
	Department department;//可以处理的部门
	ArrayList<User> operator;//可以处理的人
	
	public ProcedureNode() {
		super();
	}
	
	public ProcedureNode(String step,String auth_id,Department department,ArrayList<User> operator) {
		super();
		this.step = step;
		this.auth_id = auth_id;
		this.department = department;
		this.operator = operator;
	}
	
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public String getAuth_id() {
		return auth_id;
	}
	public void setAuth_id(String auth_id) {
		this.auth_id = auth_id;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public ArrayList<User> getOperator() {
		return operator;
	}
	public void setOperator(ArrayList<User> operator) {
		this.operator = operator;
	}
	
}
