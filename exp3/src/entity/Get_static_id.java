package entity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import db.DBBean;

public class Get_static_id {
	public static String Get_Static_Id(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		String staid = "nul";
		try {
			conn = DBBean.getConnection();
			String sql = "select * from Static_Id";
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			staid = rset.getString("Sta_id");
			int i = Integer.parseInt(staid);
			i++;
			staid = Integer.toString(i);
			String sql1 = "";//修改数据库中的id号
			stmt.executeQuery(sql);
			
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
		return staid;
	}
}
