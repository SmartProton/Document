<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="entity.*"%>
<%@page import="db.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.Date"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String username = request.getParameter("username");
String user_id = request.getParameter("user_id");
Date StartDate = new Date();//需要注意开始日期#############################################################################################
session.setAttribute("StartDate", StartDate);
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
                    <a href="#none">发文管理</a>
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
           	
           	<form method="get" action="/exp3/Document/SubConfirm.jsp">
            <input type="hidden" name="username" value="<%=username%>"></input>
            <input type="hidden" name="user_id" value="<%=user_id%>"></input>
            <input type="hidden" name="department" value=""></input>
            <input type="hidden" name="procedure_id" value=""></input>
            <input type="hidden" name="writer" value=""></input>
            <input type="hidden" name="comment" value=""></input>
            <input type="hidden" name="security" value="normal"></input>
    
           	<div class="toolbar">
				<a href="DocumentManagerDraft.html"><button>存稿</button></a>
                <input type="submit" value="提交"></input>
				<a href="DocumentManagerDraft.html"><button>返回</button></a>
			</div>
			
		<div style="width:800px;margin:20px auto;">
			<div class="search_type_select">
				<div class="text_title">类型</div>
				<span class="search_select_text close">
					<a class="default">
						<select  name="type" id="type"><!--要有name和id,且都一样-->
							<option value="公告">公告</option>
                            <option value="通知">通知</option>
						</select>
					</a>
				</span>
			</div>
			<div class="search_type_select">
				<div class="text_title">文号</div>
				<input class="input_text" type="text" name="document_id" id="document_id" />
			</div>
			<div class="title_type_input">
				<div class="text_title">标题</div>
				<input class="title_input_text" type="text" name="title" id="title" />
			</div>
			<div class="main_content_div">
				<div class="text_title">正文</div>
				<textarea class="main_content_text" type="text" name="content" id="content"></textarea>
			</div>
		</div>
	</form>
	
	
	
	
              </div>     
        </div>
    </div>
  </body>
</html>
