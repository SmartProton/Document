<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
                    <a>发文管理</a>
                    <ul class="level2">
                        <li><a href="DocumentManagerDraft.html">草稿箱</a></li>
                        <li><a href="DocumentManagerBacklog.html">待办箱</a></li>
                        <li><a href="DocumentManagerTransaction.html">在办箱</a></li>
                        <li><a href="#">已办箱</a></li>
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
             <h3>首页--公文管理--发文管理--已办箱</h3>
             <h1>办理工作</h1>
             <hr style="width: 866px; color: #999;  margin-top:-2px;"/>
           <div style="width:800px;margin:20px auto;">
		<div class="search_div">
			<div class="search_title">信息查询</div>
			<div class="search_content">
				<div class="search_type_select">
					<div class="text_title">状态</div>
					<span class="search_select_text">
						<a>
							<span>请选择状态</span>
							<span>▼</span>
						</a>
					</span>
				</div>
				<div class="search_type_select">
					<div class="text_title">文号</div>
					<input class="search_select_text" />
				</div>
				<div class="search_type_select">
					<div class="text_title">类型</div>
					<span class="search_select_text">
						<a>
							<span>请选择类型</span>
							<span>▼</span>
						</a>
					</span>
				</div>
				<div class="search_type_select">
					<div class="text_title">部门</div>
					<span class="search_select_text">
						<a>
							<span>请选择部门</span>
							<span>▼</span>
						</a>
					</span>
				</div>
				<div class="search_type_date">
					<div class="text_title">日期</div>
					<div class="search_select_text"></div>
					<div class="search_select_date">...</div>
					<div class="text_title">到</div>
					<div class="search_select_text"></div>
					<div class="search_select_date">...</div>
				</div>
				<a href="#" class="search_button button_gray">查询</a>
				<div class="search_type_input">
					<div class="text_title">标题</div>
					<input class="search_input_text" />
				</div>
			</div>
		</div>
	
	
	
	
	<table class="table_content" id="dynamicTable" width="800" border="0" cellspacing="0" cellpadding="0">
		<thead>
			<tr>
				<td class="table_item item_checkbox"></td>
				<td class="table_item item_title">标题</td>
				<td class="table_item item_time">发文日期</td>
				<td class="table_item item_type">公文类型</td>
				<td class="table_item item_situation">状态</td>
				<td class="table_item item_operation">操作</td>
			</tr>
		</thead>
		<tbody>
			<tr id="teble_line1" class="table_row">
				<td class="table_item item_checkbox">1</td>
				<td class="table_item item_title">2015年国庆放假通知</td>
				<td class="table_item item_time">2015/9/30</td>
				<td class="table_item item_type">通报</td>
				<td class="table_item item_situation">办理中</td>
				<a href="DocumentManagerCheck.html"><td class="table_item item_operation">查看</td></a>
			</tr>
			<tr id="teble_line1" class="table_row">
				<td class="table_item item_checkbox">2</td>
				<td class="table_item item_title">2015年软件产品代理新策略</td>
				<td class="table_item item_time">2015/9/30</td>
				<td class="table_item item_type">决议</td>
				<td class="table_item item_situation">已办结</td>
				<a href="DocumentManagerCheck.html"><td class="table_item item_operation">查看</td></a>
			</tr>
		</tbody>
	</table>
	<div class="toolbar">
				<div class="pageswitchdiv">
					<button>前一页</button>
					<span>1</span>/<span>1</span>页
					<button>后一页</button>
					<input type="text" style="width: 20px;"/>
					<button>GO</button>
				</div>
			</div>
            
              </div>     
        </div>
    </div>
  </body>
</html>
