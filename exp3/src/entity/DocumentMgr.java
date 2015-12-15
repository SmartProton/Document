package entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

import db.DBBean;
import entity.*;

public class DocumentMgr{
	
	private HashMap<String,Document> Document_List;//锟斤拷锟斤拷id锟斤拷锟斤拷

	public DocumentMgr() {
		super();
	}
	
	/**
	 * 锟矫碉拷锟斤拷锟叫癸拷锟侥碉拷锟叫憋拷
	 * to get type,title,date,state of doc..
	 * @return
	 */
	
	public ArrayList<Document> FindById(String user_id){
		ArrayList<Document> documentList = new ArrayList<Document>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		ResultSet rset1 = null;
		Document document = null;
		try {
			conn = DBBean.getConnection();
			String sql = "";//find doc_id、title、type、endtime、node by id
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			NodeLog Log = new NodeLog();
			while (rset.next()) {
				ArrayList<NodeLog> procedurelog = new ArrayList<NodeLog>();
				
				String id = rset.getString("doc_id");
				//通过id查找这篇公文的所有节点的名称，及每个节点的开始时间、结束时间
				String sql1 = "";
				rset1 = stmt.executeQuery(sql);
				while (rset1.next()) {
					String step = rset1.getString("step");
					ProcedureNode procedure_log = new ProcedureNode(step,null,null,null);
					Date Starttime = null;//直接把开始时间赋给Date
					Date Endtime = null;//直接把结束时间赋给Date
					procedurelog.add(Log.getProNodeLog(procedure_log, null, Starttime, Endtime));
				}
				
				document = new Document(null, null,rset.getString("type"),null,rset.getString("title"),null,
						-1,null,null,procedurelog);
//公文id、user_id、类型、流程类型、标题、文号、密级、备注、附件路径、历史节点
				
				documentList.add(document);
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
		return documentList;
	}
	
	/*
	 * 找到所有部门
	 */
	public ArrayList<Department> FindAllDepartment(){
		ArrayList<Department> depart = new ArrayList<Department>();
		Department newdepart = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		try {
			conn = DBBean.getConnection();
			String sql = "";//找到所有部门
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()){
				newdepart = new Department(rset.getString("department_id"),rset.getString("department_name"));
				depart.add(newdepart);
			}
		}catch (SQLException e) {
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
		return depart;
	}
	
	/*
	 * 通过公文类型找到可使用的流程，以及流程对应的相关信息
	 */
	public ArrayList<Procedure> FindProcedureByDoctype(String type){
		ArrayList<Procedure> Pro = new ArrayList<Procedure>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		ResultSet rset2 = null;
		ResultSet rset3 = null;
		Procedure proce = null;
		try {
			conn = DBBean.getConnection();
			String sql = "";//通过公文类型，找到对应的流程类型id
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			ProcedureNode p_node = null;
			Department dep = null;
			ArrayList<User> operator = new ArrayList<User>();
			User user = new User();
			ArrayList<ProcedureNode> pronode = new ArrayList<ProcedureNode>();
			while (rset.next()) {
				String Pro_id = rset.getString("procedure_id");
				String sql2 = "";//根据流程类型id，找到每个流程对应的节点、操作权限id、部门id、部门名称
				rset2 = stmt.executeQuery(sql2);
				while(rset2.next()){
					String AuthId =  rset2.getString("auth_id");
					//根据操作权限id查找可操作人username
					String sql3 = "";
					rset3 = stmt.executeQuery(sql3);
					while(rset3.next()){
						user.setusername(rset.getString("username"));
						operator.add(user);
					}
					
					dep = new Department(rset2.getString("department_id"),rset2.getString("department_name"));
					p_node = new ProcedureNode(rset2.getString("step"),rset2.getString("auth_id"),dep,operator);//可操作人
					pronode.add(p_node);
					operator.clear();//清空
				}
				proce = new Procedure(rset.getString("procedure_id"),pronode);
				Pro.add(proce);
				//清空pronode
				pronode.clear();
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
		return Pro;
	}
	
	
	public HashMap getDocumentList(){
		HashMap<String,Document> documentList = new HashMap<String,Document>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		Document document = null;
		try {
			conn = DBBean.getConnection();
			String sql = "select * from ...";//锟斤拷取锟斤拷锟叫癸拷锟斤拷锟斤拷锟�
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			while (rset.next()) {
				Procedure procedure = null;
				/*
				 * 锟斤拷锟揭癸拷锟侥讹拷应锟斤拷锟斤拷锟斤拷锟斤拷锟酵ｏ拷锟斤拷锟斤拷锟斤拷procedure
				 */
				
				ArrayList<NodeLog> procedurelog = new ArrayList<NodeLog>();
				/*
				 * 锟斤拷锟揭癸拷锟侥讹拷应锟斤拷锟斤拷锟教节碉拷锟斤拷史锟斤拷锟斤拷锟斤拷锟斤拷procedurelog
				 * 锟斤拷锟斤拷锟斤拷史锟节点，也锟斤拷锟角诧拷锟斤拷锟斤拷锟教节点、锟斤拷锟斤拷员id锟斤拷锟节点开始锟斤拷锟节★拷锟节碉拷锟斤拷锟斤拷锟斤拷锟�
				 */
			
				ProcedureNode procedure_log = null;
				/*
				 * 锟斤拷锟斤拷锟斤拷史锟节碉拷锟斤拷锟斤拷探诘锟斤拷锟襟，诧拷锟斤拷锟斤拷procedure_log
				 */
				
				String Operator_id = null;
				/*
				 * 锟揭碉拷锟斤拷史锟节碉拷锟接︼拷牟锟斤拷锟皆眎d锟斤拷锟斤拷锟斤拷锟斤拷operator_id
				 */
				
				Date Starttime = null;
			    /*
				 * 锟揭碉拷锟斤拷史锟节碉拷锟接︼拷目锟绞硷拷锟斤拷冢锟斤拷锟斤拷锟斤拷锟絪tarttime
				 */
				
				Date Endtime = null;
				/*
				 * 锟揭碉拷锟斤拷史锟节碉拷锟接︼拷慕锟斤拷锟斤拷锟斤拷冢锟斤拷锟斤拷锟斤拷锟絜ndtime
				 */
				
				NodeLog Log = new NodeLog();
				procedurelog.add(Log.getProNodeLog(procedure_log, Operator_id, Starttime, Endtime));//锟斤拷锟斤拷锟斤拷锟教节碉拷锟斤拷史锟斤拷锟斤拷
				//循锟斤拷锟斤拷锟�
				
				
				document = new Document(rset.getString("doc_id"), rset.getString("writer"),
						rset.getString("type"),procedure,rset.getString("title"),rset.getString("document_number"),
						rset.getInt("rank"),rset.getString("remark"),rset.getString("enclosure_dir"),procedurelog);

				documentList.put(rset.getString("doc_id"), document);
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
		return documentList;
	}

	public int addDocument(Document newDocument) {
		int result = 0; //
		if (findDocument(newDocument)) {
			result = 1; //
		} else {
			String sql = "insert into ......";//锟斤拷庸锟斤拷锟斤拷锟斤拷

			if (DBBean.update(sql)) {
				result = 2; //
			}
		}
		return result;
	}

	public boolean findDocument(Document document) {
		boolean result = false;
		String sql = "";//锟斤拷锟揭癸拷锟斤拷锟斤拷锟�
		result = DBBean.hasRecord(sql);
		return result;
	}

	public boolean deleteDocument(String doc_id) {
		boolean result = false;
		String sql = "";//删锟斤拷锟斤拷锟斤拷锟�
		result = DBBean.delete(sql);
		System.out.println("delete user:" + sql);
		return result;
	}

	public Document getDocument(String doc_id) {
		String sql = "";//锟斤拷锟揭癸拷锟斤拷锟斤拷锟�
		Document document = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		try {
			conn = DBBean.getConnection();
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			int i = 0;
			while (rset.next()) {
				
				
				Procedure procedure = null;
				/*
				 * 锟斤拷锟揭癸拷锟侥讹拷应锟斤拷锟斤拷锟斤拷锟斤拷锟酵ｏ拷锟斤拷锟斤拷锟斤拷procedure
				 */
			
				ArrayList<NodeLog> procedurelog = new ArrayList<NodeLog>();
				/*
				 * 锟斤拷锟揭癸拷锟侥讹拷应锟斤拷锟斤拷锟教节碉拷锟斤拷史锟斤拷锟斤拷锟斤拷锟斤拷procedurelog
				 * 锟斤拷锟斤拷锟斤拷史锟节点，也锟斤拷锟角诧拷锟斤拷锟斤拷锟教节点、锟斤拷锟斤拷员id锟斤拷锟节点开始锟斤拷锟节★拷锟节碉拷锟斤拷锟斤拷锟斤拷锟�
				 */
			
				//循锟斤拷锟斤拷锟�###########################################################################
				ProcedureNode procedure_log = null;
				/*
				 * 锟斤拷锟斤拷锟斤拷史锟节碉拷锟斤拷锟斤拷探诘锟斤拷锟襟，诧拷锟斤拷锟斤拷procedure_log
				 */
				
				String Operator_id = null;
				/*
				 * 锟揭碉拷锟斤拷史锟节碉拷锟接︼拷牟锟斤拷锟皆眎d锟斤拷锟斤拷锟斤拷锟斤拷operator_id
				 */
				
				Date Starttime = null;
			    /*
				 * 锟揭碉拷锟斤拷史锟节碉拷锟接︼拷目锟绞硷拷锟斤拷冢锟斤拷锟斤拷锟斤拷锟絪tarttime
				 */
				
				Date Endtime = null;
				/*
				 * 锟揭碉拷锟斤拷史锟节碉拷锟接︼拷慕锟斤拷锟斤拷锟斤拷冢锟斤拷锟斤拷锟斤拷锟絜ndtime
				 */
				
				NodeLog Log = new NodeLog();
				procedurelog.add(Log.getProNodeLog(procedure_log, Operator_id, Starttime, Endtime));//锟斤拷锟斤拷锟斤拷锟教节碉拷锟斤拷史锟斤拷锟斤拷
				//循锟斤拷锟斤拷锟�############################################################################
				
				
				
				document = new Document(rset.getString("doc_id"), rset.getString("writer"),
						rset.getString("type"),procedure,rset.getString("title"),rset.getString("document_number"),
						rset.getInt("rank"),rset.getString("remark"),rset.getString("enclosure_dir"),procedurelog);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBBean.clean(conn, stmt, rset);
		}
		return document;
	}

	public int editDocument(Document document) {
		int result = 1;
		String sql = "";//锟斤拷锟铰癸拷锟斤拷锟斤拷息
		if (DBBean.update(sql)) {
			result = 2; 
		}
		return result;
	}
	

}
