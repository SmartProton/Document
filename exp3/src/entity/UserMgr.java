package entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import db.DBBean;

public class UserMgr {
	
	private HashMap<String,User> userList;

	public UserMgr() {
		super();
	}
	
	/**
	 * �õ������û����б�
	 * 
	 * @return
	 */
	

	
	public HashMap getUserList(){
		HashMap<String,User> userList = new HashMap();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		User user = null;
		try {
			conn = DBBean.getConnection();
			String sql = "select * from User";
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			while (rset.next()) {
				user = new User(rset.getString("user_id"), rset.getString("password"),
						rset.getString("username"), rset.getBoolean("sex"),
						rset.getString("job"),rset.getString("depart"));

				userList.put(rset.getString("username"), user);
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
		return userList;
	}

	public int addUser(User newUser) {
		int result = 0; //
		if (findUser(newUser)) {
			result = 1; //
		} else {
			String sql = "insert into User......";//����û�����ݿ����

			if (DBBean.update(sql)) {
				result = 2; //
			}
		}
		return result;
	}

	public boolean findUser(User user) {
		boolean result = false;
		String sql = "";//�����������ݿ����
		result = DBBean.hasRecord(sql);
		return result;
	}

	public boolean deleteUser(String user_id){
		boolean result = false;
		String sql = "";//ɾ���������ݿ����
		result = DBBean.delete(sql);
		System.out.println("delete user:" + sql);
		return result;
	}

	public User getUser(String user_id) {
		String sql = "select * from ���� where user_id=('" + user_id
				+ "')";//�����������ݿ����
		User user = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		try {
			conn = DBBean.getConnection();
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			int i = 0;
			while (rset.next()) {
				user = new User(rset.getString("user_id"), rset.getString("password"),
						rset.getString("username"), rset.getBoolean("sex"),
						rset.getString("job"),rset.getString("depart"));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBBean.clean(conn, stmt, rset);
		}
		return user;
	}

	public int editUser(User user) {
		int result = 1;
		String sql = "update ...... set username ='" +  "',usertype='"
				 + "where username=('"
				+ user.getusername() + "')";//������ݿ����
		if (DBBean.update(sql)) {
			result = 2; 
		}

		return result;
	}
	
	public String verifyUser(String username, String password){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		String result = "Error...";
		System.out.println("this is verifyuser");
		try {
			conn = DBBean.getConnection();
			String sql = "select * from usertable where user_name='" + username
					+ "' and passwd='" + password + "'";
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			System.out.println("this is sqlsearch");
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
}
