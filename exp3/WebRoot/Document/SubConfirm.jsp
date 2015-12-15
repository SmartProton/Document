<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="entity.*"%>
<%@page import="db.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.Date"%>
<jsp:useBean id="documentMgr" class="entity.DocumentMgr" scope="application" />

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
String username = request.getParameter("username");
String user_id = request.getParameter("user_id");
String Type = request.getParameter("type");
String Document_id = request.getParameter("document_id");//获取参数文号
String Title = request.getParameter("title");
String Content = request.getParameter("content");
username = new String(username.getBytes("iso8859-1"), "utf-8");
Title = new String(Title.getBytes("iso8859-1"), "utf-8");
Type = new String(Type.getBytes("iso8859-1"), "utf-8");
Document_id = new String(Document_id.getBytes("iso8859-1"), "utf-8");

Boolean Tag = true;//回传
String Department = request.getParameter("department");//获取本页面新添参数
String Procedure_id = request.getParameter("procedure_id");
String Writer = request.getParameter("writer");
String Comment = request.getParameter("comment");
String Security = request.getParameter("security");
Security = new String(Security.getBytes("iso8859-1"), "utf-8");
Comment = new String(Comment.getBytes("iso8859-1"), "utf-8");
Writer = new String(Writer.getBytes("iso8859-1"), "utf-8");
Procedure_id = new String(Procedure_id.getBytes("iso8859-1"), "utf-8");
Department = new String(Department.getBytes("iso8859-1"), "utf-8");
if(Security.equals(""))
{
Tag = false;
}
%>
<!DOCTYPE html> 
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>backlog</title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="./css/StyleSheet.css"/>
    <link rel="stylesheet" type="text/css" href="./css/DocumentManagerDraft.css" />
	<script src="./js/menu.js"></script>
    <script src="./js/jquery1.7.js"></script>
    <script src="../js/jquery-1.9.1.min.js"></script>
    <script src="../js/jquery.selectlist.js"></script>
   		
   	<script type="text/javascript">
   		function change(){
   			x=document.getElementById("form1");
   			q=document.getElementById("op");
   			q.value="change_op";
   			x.submit();
   		}
   	</script>	
  	</head>
  
  <body>
 <div id="header">
        <div id="logo">
            <img src="./img/logo.png" width="75" height="60" />
        </div>
        <div id="biaoti">
            <h1>公文审批</h1>
        </div>
        <div id="caidan">
            <ul>
                <li><a href="#">首页</a></li>
                <li><a href="#">公文管理</a></li>
                <li><a href="#">内容管理</a></li>
                <li><a href="#">个人事务</a></li>
                <li><a href="#">公共事务</a></li>
                <li><a href="#">综合信息</a></li>
            </ul>
        </div>
    </div>

    <div id="content">
        <div id="note">
            <div id="box">
                <img src="./img/userpic.png" width="37" height="31" />
            </div>
            <h2>尊敬的用户，欢迎您！</h2>
            <div id="mes">
                <ul>
                    <li><a href="#">未读消息【0】   |</a></li>
                    <li><a href="#">个人中心   |</a></li>
                    <li><a href="#">退出   |</a></li>
                </ul>
            </div>
        </div>
       
        <div class="sidebar">
            <ul class="menu">
                <li class="level1">
                    <a>发文管理</a>
                    <ul class="level2">
                        <li><a href="DocumentManagerDraft.html">草稿箱</a></li>
                        <li><a href="DocumentManagerBacklog.html">待办箱</a></li>
                        <li><a href="DocumentManagerTransaction.html">在办箱</a></li>
                        <li><a href="DocumentManagerHandled.html">已办箱</a></li>
                    </ul>
                </li>
                <li class="level1">
                    <a href="#none">收文管理</a>
                    <ul class="level2">
                        <li><a href="DocumentManagerRecBacklog.html">待办箱</a></li>
                        <li><a href="DocumentManagerRecTransaction.html">在办箱</a></li>
                        <li><a href="DocumentManagerRecHandled.html">已办箱</a></li>
                    </ul>
                </li>
                <li class="level1">
                    <a href="#none">发文登记</a>
                    <ul class="level2">
                        <li><a href="DocumentManagerRegisterHandled.html">完成箱</a></li>
                        <li><a href="DocumentManagerRegisterEnded.html">终止箱</a></li>
                    </ul>
                </li>
                <li class="level1">
                    <a href="#none">收文登记</a>
                    <ul class="level2">
                        <li><a href="DocumentManagerRecRegisterHandled.html">完成箱</a></li>
                        <li><a href="DocumentManagerRecRegisterEnded.html">终止箱</a></li>
                    </ul>
                </li>
                <li class="level1">
                    <a href="#none">督办管理</a>
                    <ul class="level2">
                        <li><a href="DocumentManagerSuperviseDraft.html">草稿箱</a></li>
                        <li><a href="DocumentManagerSuperviseBacklog.html">待办箱</a></li>
                        <li><a href="DocumentManagerSuperviseTransaction.html">在办箱</a></li>
                        <li><a href="DocumentManagerSuperviseHandled.html">完成箱</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        
        <div class="text">
            <h3>首页--公文管理--发文管理--拟稿</h3>
            <h1>拟稿</h1>
            <hr style="width: 866px; color: #999;  margin-top:-2px;"/>
          	<div style="width:800px;margin:20px auto;">
           	
           	<form method="get" action="servlet/DocumentServlet" id="form1">
           		<input type="hidden" name="content" id="content" value="<%=Content %>"></input>
           		<input type="hidden" name="username" id="username" value="<%=username%>"></input>
           		<input type="hidden" name="user_id" id="user_id" value="<%=user_id%>"></input>
           		<input type="hidden" name="op" id="op" value="sub"></input>
	           	<div class="toolbar">
					<button>存稿</button>
					<input type="submit" value="确认提交"></input>
					<a href="DocumentManagerContribution.html"><button>返回正文</button></a>
					<a href="DocumentManagerDraft.html"><button>取消</button></a>
				</div>
			
				<div style="width:800px;margin:20px auto;">
					<div class="input_div_line">
						<div class="text_title_s">标题</div>
						<input class="input_text" type="text" value="<%=Title %>" id="title" name="title"/>
					</div>
					<div class="input_div_line">
						<div class="text_title_s">公文类型</div>
							<a>
								<input type="text" id="type" name="type" value="<%=Type %>"></input>
							</a>
					</div>
					<div class="input_div_line">
						<div class="text_title_s">文号</div>
						<input class="input_text" type="text" id="document_num" name="document_num" value="<%=Document_id %>" />
					</div>
					<div class="input_div">
					<%
						//查询所有部门
						ArrayList<Department> all_department = documentMgr.FindAllDepartment();
						int Department_Size = all_department.size();
						String Department_name = "n";
					%>
						<div class="text_title_s">拟稿部门</div>
						<span class="search_select_text">
							<a>
								<select id="department" name="department">
									<%
									for(int m = 0; m < Department_Size; m++){
										Department_name = all_department.get(m).getDepartment_name();
										if(Tag){
											if(Department.equals(Department_name)){
									%>
												<option value="<%=Department_name %>" selected="selected"></option>
									<%
											}else{
											%>
												<option value="<%=Department_name %>"></option>
											<%
											}
										}
										else{
											if(m == 0){
											%>
												<option value="<%=Department_name %>" selected="selected"></option>
											<%
											}else{
											%>
											<option value="<%=Department_name %>"></option>
											<%
											}
										}
									}
									
									%>
								</select>
								<span>▼</span>
							</a>
						</span>
					</div>
					<div class="input_div">
						<div class="text_title_s">拟稿人</div>
						<input class="input_text" type="text" id="writer" name="writer" value="<%=Writer %>" />
					</div>
				
						<div class="text_title_s">密级</div>
						<%
						if(Security.equals("normal")){
						%>
						<input type="radio" checked="checked" name="security" id="security1" value="normal"/>普通
						<input type="radio" name="security" id="security2" value="secret"/>机密
						<input type="radio" name="security" id="security3" value="confidential"/>绝密
						<%
					}else if(Security.equals("secret")){
					%>
						<input type="radio" name="security" id="security1" value="normal"/>普通
						<input type="radio" checked="checked" name="security" id="security2" value="secret"/>机密
						<input type="radio" name="security" id="security3" value="confidential"/>绝密
					<%
					}else{
					%>
						<input type="radio" name="security" id="security1" value="normal"/>普通
						<input type="radio" name="security" id="security2" value="secret"/>机密
						<input type="radio" checked="checked" name="security" id="security3" value="confidential"/>绝密
					<%
			}
						
						%>
						
						
					<div class="input_div_line">
						<div class="text_title_s">备注</div>
						<textarea class="input_text_s" type="text" id="comment" name="comment" ></textarea>
					</div>
					<div>
						<span>选择流程</span>
						<%
							//根据公文类型找出对应流程类型、包括流程id.需要将流程传给servlet
							ArrayList<Procedure> pro = documentMgr.FindProcedureByDoctype(Type);
							int Size = pro.size();
							session.setAttribute("Doctype2Proceduretype", pro);
						%>
						<select id="procedure_id" name="procedure_id" onchange="change()">
							<%
								String pro_id = "n";
								for(int i = 0; i < Size; i++){
									pro_id = pro.get(i).getProcedure_id();//流程选择
									if(Tag&&Procedure_id.equals(pro_id)){
							%>
									<option value="<%=pro_id %>" selected="selected"></option>
							<%
									}else{
							%>
									<option value="<%=pro_id %>"></option>
							 <%}}%>
							 
						</select>
					</div>
				</div>
       			<hr style="width: 600px; color: #CCCCCC;  margin:10px 50px;float: left;"/>
       			<div style="float:left;width: 800px;font-size: 16px;margin: 10px 0;text-align: center;">流程步骤</div>
       			<script type="text/javascript">
       				
       			</script>
       			<table class="table_content" id="dynamicTable" width="800" border="0" cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<td class="table_item item_checkbox"></td>
							<td class="table_item item_process">流程名称</td>
							<td class="table_item item_operadepart">操作部门</td>
							<td class="table_item item_power">操作权限</td>
							<td class="table_item item_process_situation">流程状态</td>
						</tr>
					</thead>
					<tbody>
					<%

						//根据流程类型id找出流程，返回流程名称、流程处理部门、流程可操作人、、流程状态(都是未处理)
						Procedure show_procedure = null;
						for(int j = 0; j < Size; j++){
							if(pro.get(j).getProcedure_id().equals(Procedure_id)){
								show_procedure = pro.get(j);
								ArrayList<ProcedureNode> show_procedure_node = show_procedure.getProcedure();
								int Show_Size = show_procedure_node.size();
								for(int l = 1; l <= Show_Size; l++){
									ProcedureNode Show_Node = show_procedure_node.get(l-1);
									String Show_Step = Show_Node.getStep();
									String Show_Departmrnt_Name = Show_Node.getDepartment().getDepartment_name();
									String Show_Username = Show_Node.getOperator().get(0).getusername();
								%>
									<tr class="table_row">
										<td class="table_item item_checkbox"><%=l%></td>
										<td class="table_item item_process"><%=Show_Step%></td>
										<td class="table_item item_operadepart"><%=Show_Departmrnt_Name%></td>
										<td class="table_item item_power"><%=Show_Username%> 等</td>
										<td class="table_item item_process_situation">待处理</td>
									</tr>
								<%
								}
							}
						}


					%>
					
						
					
					</tbody>
				</table>
				<div class="toolbar">
					<button>存稿</button>
					<input type="submit" value="确认提交"></input>
					<button>返回正文</button>
					<button>取消</button>
				</div>
				<div class="push_bottom"></div>
				</form>
            </div>     
       		
       		
       		
       		
        </div>
    </div>
  </body>
</html>
