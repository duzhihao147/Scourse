<%@ page language="java" import="java.util.*,com.ten.user.Teacher" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
	<title>学生选课信息管理系统-后台管理</title>
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
	 <%
	  	Teacher tea = null;
	  	if(session.getAttribute("teacher")==null){
	  		response.sendRedirect("/Ten/Login.jsp");
	  	}else{
	  		tea = (Teacher)session.getAttribute("teacher");
	   %>
	<div class="top">
		<div class="title"><p> 学生选课信息管理系统 </p></div>
	</div>
	<div class="main">
		<div class="main_left">
			<div class="main_left_class00"><img src=img/touxiang.png></div>
			<div class="main_left_class01"><a href="tea/selectCou.jsp">选课管理</a></div>
			<div class="main_left_class02"><a href="tea/selectStu.jsp">学生信息</a></div>
			<div class="main_left_class03"><a href="tea/Query.jsp"">信息查询</a></div>
			<div class="main_left_class04"><a href="tea/upload.jsp">信息上传</a></div>
			<div class="main_left_class100">
			<input class="reset" type="button" value="注销" onClick="window.location.href=('/Ten/servlet/serDoLogout')">
			</div>
		</div>
		<div class="main_right">
			<div class="info">
				<p>亲爱的<%= tea.getTname() %>老师，下午好</p>
			</div>
			<div class="box">
				<div class="function"><p>[通知]选课系统已开放</p></div>
				<div class="form">
				<table class="news">
			<tr><td><h2>关于本学期校级任选课相关事宜安排的通知</h2></td></tr>
			<tr><td>各学院及相关单位:</td></tr>
			<tr><td>请组织本院2015级、2016级、2017、2018级学生登陆教务系统选专业选修课，现将具体事宜通知如下：</td></tr>
			<tr><td>一、选课时间：2019年1月7日8：00 —— 1月11日12：00</td></tr>
			<tr><td>二、选课对象：2015级、2016级、2017、2018级全日制本科生。</td></tr>
			<tr><td>三、开放专业选修课的学院：计算机与信息科学学院、软件学院</td> </tr>
			<tr><td>四、注意事项：</td></tr>
			<tr><td>1.	请同学们务必在系统开放时间内用计算机（非手机等移动终端）进行选课或退选操作，未确认课程，将不能登载成绩。</td></tr>
			<tr><td>2.	专业选修课的退课时间暂定为下学期开学的第一周（2019年2月25日——3月3日）</td> </tr>
			<tr><td>3.  选课过程中，如果由于教务系统问题无法操作选课的，请于选课期间联系：68367290。</td></tr>
			<tr><td align="right">2019年1月4日</td></tr>
			</table>
				</div>
			</div>
		</div>
	</div>
	<%} %>
	</body>
</html>
