/*
 * 要知道公文在哪个节点，属于什么箱
 * 知道公文在哪个节点，就知道谁处理，也就是公文要发给谁，在哪个箱可以根据公文状态1,2,3等等来确定，状态应该也属于每个处理人
 */

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Date;
import entity.*;

public class DocumentServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DocumentServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request,response);
	}

	//注意：
	//拟稿的时候就应该创建某些对象，比如节点，而不是提交的时候。也就是，执行某个动作的时候，就要在数据库生成所有相关数据。
	//在拟稿的时候，就应该生成公文id，历史节点、拟稿人等。对于其它动作也类似
	//否则，在执行相关动作后，在数据库就找不到执行过的痕迹
	public void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String user_id = request.getParameter("user_id");
		String current_page = request.getParameter("current_page");
		String op = request.getParameter("op");
		String title = request.getParameter("title");
		String type = request.getParameter("type");
		String procedure_id = request.getParameter("procedure_id");//流程类型参数id
		String document_num = request.getParameter("document_num");
		String department = request.getParameter("department");
		String writer = request.getParameter("writer");
		String remark = request.getParameter("comment");
		String security = request.getParameter("security");
		
		HttpSession session = request.getSession();
		if(op.equals("change_op")){//修改流程id
			//document_id还需确定
			request.getRequestDispatcher("/Document/SubConfirm.jsp?username="+username+"&user_id="+user_id+"&type="+type+"&document_id="+document_num+"&title="+title+
					"&procedure_id="+procedure_id+"&department="+department+
					"&writer="+writer+"&comment="+remark+"&security="+security).forward(request, response);
		}
 		else if(op.equals("sub")){//提交
			ArrayList<Procedure> Dt2Pt = (ArrayList<Procedure>)session.getAttribute("Doctype2Proceduretype");
			Procedure NewProcedure = null;
			int Size = Dt2Pt.size();
			for(int i = 0; i< Size; i++){
				if(Dt2Pt.get(i).getProcedure_id().equals(procedure_id)){
					NewProcedure = Dt2Pt.get(i);//得到用户选中的流程
					break;
				}
			}	
			int rank = -1;
			//根据密级转换成int
			if(security.equals("normal")){
				rank = 1;
			}else if(security.equals("secret")){
				rank = 2;
			}else {
				rank = 3;
			}
			
			String document_id = Get_static_id.Get_Static_Id();//拟稿的时候创建
			//获取拟稿的历史节点
			ProcedureNode Proce_Node = new ProcedureNode("拟稿","0",null,null);
			Date EndDate = new Date();
			System.out.println(EndDate.toString());
			Date StartDate = (Date)session.getAttribute("StartDate");
			NodeLog nodelog = new NodeLog(Proce_Node,user_id,StartDate,EndDate);//开始时间
			ArrayList<NodeLog> log = new ArrayList<NodeLog>();
			log.add(nodelog);
			
			//新建一个公文对象
			Document doc = new Document(document_id,writer,type,NewProcedure,title,document_num,rank,remark,null,log);
			
			/*
			 * 将相关信息添加到数据库
			 */
			
			request.getRequestDispatcher("/Document/Draft.jsp?username="+username+"&user_id="+user_id).forward(request, response);
			}
		
		
		}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
