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
	<title>文件上传</title>
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
			<center><div class="function"><p>文件或图片上传</p></div></center>
			<div class="form">
			<div class="form_1">
				<center><form action="${pageContext.request.contextPath}/servlet/UploadHandleServlet" enctype="multipart/form-data" method="post">
      			     
				<table>
				
  					<center></center>
  					<tr><td></td></tr>
  					<tr><td>上传用户：</td> <td><input  type="text"  class="text"  name="username"/></td></tr>
  					<tr><td>上传文件1：</td> <td><input  type="file" class="text"  name="file1"/></td></tr>
  					<tr><td>上传文件2：</td> <td><input  type="file" class="text"  name="file2"/></td></tr>
  					<tr><td></td><td><input class="btn" type="submit" value="提交"/>  </td></tr>
 
  					</center>
  				</table>
               </form></center>
  				</div>
  				</div>
				
			</div>
		</div>
	</div>
</body>
</html>