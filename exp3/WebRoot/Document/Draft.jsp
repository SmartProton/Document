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
String aa = request.getParameter("a");
System.out.println(aa);

int current_page = 1;//当前页
String cur_page = request.getParameter("current_page");
if(cur_page != null && cur_page.equals("0") == false){
	current_page = Integer.parseInt(cur_page);
}

System.out.println("page 123");
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

            <%
            	 String username = request.getParameter("username");
            	 String user_id = request.getParameter("user_id");
            	 ArrayList<Document> DocList = new ArrayList<Document>();
            	 DocList = documentMgr.FindById(user_id);//通过id找到公文
            	 int size = DocList.size();//返回公文长度
            	 int page_doc_num = 10;//每页公文数
            	 int page_num = 0;//页数index
            	 if(size == 0) page_num = 1;
            	 else {
            	 	page_num = (size -1)/page_doc_num + 1;
            	 } 
            	 if(current_page > page_num){
            	 	current_page = page_num;
            	 }
             %>
             
             
            <h2>尊敬的<%=username %>，欢迎您！</h2>
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
                        <li><a href="#">草稿箱</a></li>
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
             <h3>首页--公文管理--发文管理--草稿箱</h3>
             <h1>发文拟稿</h1>
             <hr style="width: 866px; color: #999;  margin-top:-2px;"/>
           <div style="width:800px;margin:20px auto;">
			<div class="toolbar">
				<input type="button" value="拟稿" onClick="location.href='../Document/Contribution.jsp?username=<%=username%>&user_id=<%=user_id %>'">
				<input type="button" value="前一页" onClick="location.href='../Document/Draft.jsp?username=<%=username%>&user_id=<%=user_id %>&current_page=<%=(current_page-1) %>'">
				<button>删除</button>
				<button>
					<a>
						<span class="select_txt">请选择公文类型</span>
						<span class="ico_select_s">▼</span>
					</a>
				</button><!-- -->
				
			
				<div class="pageswitchdiv">
					<input type="button" value="前一页" onClick="location.href='../Document/Draft.jsp?username=<%=username%>&user_id=<%=user_id %>&current_page=<%=(current_page-1) %>'">					
					<span><%=current_page %></span>/<span><%=page_num %></span>页
					<input type="button" value="后一页" onClick="location.href='../Document/Draft.jsp?username=<%=username%>&user_id=<%=user_id %>&current_page=<%=(current_page+1) %>'">
					<input type="text" name="select_page" id="select_page" style="width: 50px;"/>
					
					<input type="button" value="GO" onClick="location.href='../Document/Draft.jsp?username=<%=username%>&user_id=<%=user_id %>'"/>
				</div>
			</div>
	
	
	
	
	<table class="table_content" id="dynamicTable" width="800" border="0" cellspacing="0" cellpadding="0">
		<thead>
			<tr>
				<td class="table_item item_checkbox">
					<input type="checkbox"/>
				</td>
				<td class="table_item item_title">标题</td>
				<td class="table_item item_time">修改时间</td>
				<td class="table_item item_type">公文类型</td>
				<td class="table_item item_situation">状态</td>
				<td class="table_item item_operation">操作</td>
			</tr>
		</thead>
		<tbody>
		<%	
			int number = ((size-(current_page-1)*page_doc_num) <= page_doc_num ? size :  page_doc_num);//实际上每页显示的公文数

				for(int i=0;i<number;i++){		
					Document d = DocList.get(i);
					ArrayList<NodeLog> Log = d.getprocedurelog();//有个拟稿状态节点
					Date Etime = Log.get(0).getEndtime();
					String AlterTime = Etime.toString();
					
					String state = "s";
					String op = "o";
					if(Log.size() == 1){
						state = "编辑中";
						op = "编辑";
					}else{
						state = "已完成";
						op = "查看";
					}
		%>
			<tr id="teble_line1" class="table_row">
				<td class="table_item item_checkbox">
					<input type="checkbox"/>
				</td>
				<td class="table_item item_title"><%=d.getTitle()%></td>
				<td class="table_item item_time"><%=AlterTime%></td>
				<td class="table_item item_type"><%=d.getType()%></td>
				<td class="table_item item_situation"><%=state%></td>
				<td class="table_item item_operation"><a href="#"><%=op%></a></td>

			</tr>
			<%} %>
		</tbody>
	</table>
	
            
              </div>     
        </div>
    </div>
  </body>
</html>
