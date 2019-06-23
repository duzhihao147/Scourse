<%@ page language="java" import="java.util.*,com.ten.user.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
	<title>学生选课信息管理系统-学生注册</title>
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
			<div class="main_left_class100">
		</div>
	</div>
	<div class="main_right">
		<div class="box">
			<div class="function"><p>学生用户注册界面</p></div>
			<div class="form">
			<div class="form_1">
				<form action="${pageContext.request.contextPath }/register" method="post">
				 
				<table>
				
  					<center></center>
  					<tr><td></td></tr>
  					<tr><td>学生姓名</td> <td><input  class="text" type="text" name="Sname"/></td></tr>
  					<tr><td>学生密码</td> <td><input  class="text" type="text" name="Spassword"/></td></tr>
  					<tr><td>学生班级</td> <td><input  class="text" type="text" name="Sclass"/></td></tr>
  					<tr><td>学生性别</td> <td><input  class="text" type="text" name="Ssex"/></td></tr>
  					<tr><td></td><td><input class="btn" type="submit" value="注册"/>  </td></tr>
 
  					</center>
  				</table>
  				</form>
  				</div>
  				</div>
				
			</div>
		</div>
	</div>
</body>
</html>
