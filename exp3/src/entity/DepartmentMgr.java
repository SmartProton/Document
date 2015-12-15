package entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import db.DBBean;

public class DepartmentMgr{
	
	private HashMap<String,Department> departmentList;

	public DepartmentMgr() {
		super();
	}
	
	/**
	 * �õ����в��ŵ��б�
	 * 
	 * @return
	 */
	

	
	public HashMap getDepartmentList(){
		HashMap<String,Department> departmentList = new HashMap();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		Department department = null;
		try {
			conn = DBBean.getConnection();
			String sql = "select * from ...";//���Ҳ������
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			while (rset.next()) {
				department = new Department(rset.getString("department_id"), rset.getString("department_name"));
				departmentList.put(rset.getString("department_id"), department);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return departmentList;
	}

	public int addDepartment(Department newDepartment) {
		int result = 0; //
		if (findDepartment(newDepartment)) {
			result = 1; //
		} else {
			String sql = "insert into User......";//��Ӳ��������ݿ����

			if (DBBean.update(sql)) {
				result = 2; //
			}
		}
		return result;
	}

	public boolean findDepartment(Department department) {
		boolean result = false;
		String sql = "";//���Ҳ�����������ݿ����
		result = DBBean.hasRecord(sql);
		return result;
	}

	public boolean deleteDepartment(String department_name) {
		boolean result = false;
		String sql = "";//ɾ����������ݿ����
		result = DBBean.delete(sql);
		System.out.println("delete user:" + sql);
		return result;
	}

	public Department getDepartment(String department_name) {
		String sql = "";//������������ݿ����
		Department department = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		try {
			conn = DBBean.getConnection();
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			int i = 0;
			while (rset.next()) {
				department = new Department(rset.getString("department_id"), rset.getString("department_name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBBean.clean(conn, stmt, rset);
		}
		return department;
	}
/*
	public int editUser(User user) {
		int result = 1;
		String sql = "update ...... set username ='" +  "',usertype='"
				 + "where username=('"
				+ user.getusername() + "')";//�������ݿ����
		if (DBBean.update(sql)) {
			result = 2; 
		}

		return result;
	}
	*/
	/*
	public String verifyUser(String username, String password){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		String result = "Error...";
		try {
			conn = DBBean.getConnection();
			String sql = "select * from ...... where username='" + username
					+ "' and password='" + password + "'";//��ѯ���ݿ����
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			if (rset.next()) {
				result = rset.getString("user_id");
				System.out.println("user_id: " + result);
			}
		} catch (SQLException e) {
			System.out.println("SQLException inside verify user");
			e.printStackTrace();

		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}*/
}

