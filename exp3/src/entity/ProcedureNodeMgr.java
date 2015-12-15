package entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import db.DBBean;
import entity.Department;

public class ProcedureNodeMgr{
	
	private HashMap<String,ProcedureNode> ProcedureNodeList;

	public ProcedureNodeMgr() {
		super();
	}
	
	/**
	 * �õ��������̽ڵ���б�
	 * 
	 * @return
	 */
	

	
	public HashMap getProcedureNodeList(){
		HashMap<String,ProcedureNode> ProcedureNodeList = new HashMap();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		ProcedureNode procedureNode = null;
		try {
			conn = DBBean.getConnection();
			String sql = "select * ...";//�������̽ڵ�����
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			while (rset.next()) {
				Department department = null;
				/*
				 * �ҵ��ڵ��Ӧ�Ĳ��ţ����ظ�department
				 */
				
				ArrayList<User> operator = null;
				/*
				 * �ҵ����̽ڵ��Ӧ�Ĳ�����Ա�����ظ�ArrayList<User> operator
				 */
				
				procedureNode = new ProcedureNode(rset.getString("step"), rset.getString("auth_id"),
						department,operator);

				ProcedureNodeList.put(rset.getString("step"),procedureNode);
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
		return ProcedureNodeList;
	}

	public int addProcedureNode(ProcedureNode newProcedureNode) {
		int result = 0; //
		if (findProcedureNode(newProcedureNode)) {
			result = 1; //
		} else {
			String sql = "insert into......";//��ӽڵ������ݿ����

			if (DBBean.update(sql)) {
				result = 2; //
			}
		}
		return result;
	}

	public boolean findProcedureNode(ProcedureNode procedureNode) {
		boolean result = false;
		String sql = "";//���ҽڵ������ݿ����
		result = DBBean.hasRecord(sql);
		return result;
	}

	public boolean deleteProcedureNode(String step){
		boolean result = false;
		String sql = "";//ɾ���ڵ������ݿ����
		result = DBBean.delete(sql);
		System.out.println("delete user:" + sql);
		return result;
	}

	public ProcedureNode getProcedureNode(String step) {
		String sql = "";//���ҽڵ������ݿ����
		ProcedureNode procedureNode = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		try {
			conn = DBBean.getConnection();
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			int i = 0;
			while (rset.next()) {
				
				Department department = null;
				/*
				 * �ҵ��ڵ��Ӧ�Ĳ��ţ����ظ�department
				 */
				
				ArrayList<User> operator = null;
				/*
				 * �ҵ����̽ڵ��Ӧ�Ĳ�����Ա�����ظ�ArrayList<User> operator
				 */
				
				procedureNode = new ProcedureNode(rset.getString("step"), rset.getString("auth_id"),
						department,operator);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBBean.clean(conn, stmt, rset);
		}
		return procedureNode;
	}

	
	public int editProcedureNode(ProcedureNode procedureNode) {
		int result = 1;
		String sql = "";//����procedureNode���½ڵ�
		if (DBBean.update(sql)) {
			result = 2; 
		}
		return result;
	}
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
	}
	*/
}
