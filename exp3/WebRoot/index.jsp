<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body style="text-align:center">
  <div class="logindiv">
   	<div class="logintitle">Login</div>
    	<form class="form1" name="form1" method="post" action="servlet/LoginServlet">
    	  <p>
    	    <label for="username">username</label>
    	    <input type="text" name="username" id="username">
  	    </p>
    	  <p>
    	    <label for="password">password</label>
    	    <input type="password" name="password" id="password">
    	  </p>
    	  <p>
    	    <input type="submit" name="login" id="login" value="Sign in">
    	  </p>
      </form>
    </div>
  </body>
</html>
