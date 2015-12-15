package entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import db.DBBean;

public class ProcedureMgr{
	
	private HashMap<String,Procedure> ProcedureList;

	public ProcedureMgr() {
		super();
	}
	
	/**
	 * �õ��������̵��б�
	 * 
	 * @return
	 */
	

	
	public HashMap getProcedureList(){
		HashMap<String,Procedure>  ProcedureList = new HashMap();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		 Procedure procedure = null;
		try {
			conn = DBBean.getConnection();
			String sql = "";//����������������
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			while (rset.next()) {
				ArrayList<ProcedureNode> proc = null;
				/*
				 * �ҵ����̶�Ӧ�����нڵ㣬��װ��proc
				 */

				procedure = new  Procedure(rset.getString("procedure_id"), proc);

				ProcedureList.put(rset.getString("procedure_id"),procedure);
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
		return ProcedureList;
	}

	public int addProcedure(Procedure newProcedure) {
		int result = 0; //
		if (findProcedure(newProcedure)) {
			result = 1; //
		} else {
			String sql = "insert into ......";//������������

			if (DBBean.update(sql)) {
				result = 2; //
			}
		}
		return result;
	}

	public boolean findProcedure(Procedure procedure) {
		boolean result = false;
		String sql = "";//������������
		result = DBBean.hasRecord(sql);
		return result;
	}

	public boolean deleteProcedure(String procedure_id){
		boolean result = false;
		String sql = "";//ɾ����������
		result = DBBean.delete(sql);
		System.out.println("delete user:" + sql);
		return result;
	}

	public Procedure getProcedure(String procedure_id) {
		String sql = "";//������������
		Procedure procedure = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		try {
			conn = DBBean.getConnection();
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			int i = 0;
			while (rset.next()) {
				ArrayList<ProcedureNode> proc = null;
				/*
				 * �ҵ����̶�Ӧ�����нڵ㣬��װ��proc
				 */

				procedure = new  Procedure(rset.getString("procedure_id"), proc);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBBean.clean(conn, stmt, rset);
		}
		return procedure;
	}

	public int editProcedure(Procedure procedure) {
		int result = 1;
		String sql = "'";//������������
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
	}*/
}
