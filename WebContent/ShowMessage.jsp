<%@ page language="java" import="java.util.*,com.ten.user.*,com.ten.dao.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
	<title>学生选课信息管理系统-学生信息</title>
	<link href="style_1.css" type="text/css" rel="stylesheet"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<div class="top">
	<div class="title"><p> 学生选课信息管理系统</p></div>
</div>
<div class="main">
	<div class="main_left">
		<div class="main_left_class00"><img src=img/touxiang.png></div>
			<div class="main_left_class02"><a href="tea/selectStu.jsp">学生信息</a></div>
			<div class="main_left_class100">
		</div>
	</div>
					<%
	  	if(request.getParameter("sumary")!=null&&request.getParameter("maxscore")!=null){
			Student.summary = Float.parseFloat(request.getParameter("sumary"));
			Student.MAXscore = Float.parseFloat(request.getParameter("maxscore"));
		}
		DaoStu select = new DaoStu();
			List<Student> list = select.selectStu();
			Iterator<Student> ite1 = list.iterator();
	   %>
	<div class="main_right">
		<div class="box">
			<div class="function"><p>[通知]选课系统已开放</p></div>
			<div class="form">
				<table>
  					<tr><td></td></tr>
  					<tr>
  						<td>学生编号</td><td>学生名称</td><td>所在班级</td><td>学生性别</td> 
  						<td><input class="btn" type="button" value="现在登录？" onclick="window.location.href=('/Ten/Login.jsp')"/></td>						
  					</tr>
			  		<%
			   			while(ite1.hasNext()){
						Student stu = ite1.next();
			   		%>
  					<tr>
  					<td><%= stu.getSNo() %></td>
  					<td><%= stu.getSname() %></td>
  					<td><%= stu.getSclass() %></td>
  					<td><%= stu.getSsex() %></td>
  					
  					</tr>
  					<%} %>
  				</table>
  			<div class="form_1">
  				<form action="tea/selectStu.jsp" method="post">
				<table>
				</table>
				</form>
				
				<%
				Iterator<Student> ite2 = list.iterator();%>
				</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
