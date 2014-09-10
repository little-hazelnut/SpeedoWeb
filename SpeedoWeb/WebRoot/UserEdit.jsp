<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UserEdit.jsp' starting page</title>
    
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
  	<form action="${basePath}servlet/EditUser" method="post">
  		<table>

  			<tr><input type="text" value="${valuePara.userId}" name="userid"></tr>

  			<tr><input type="text" value="${valuePara.userNameString}" name="username"></tr>
  			
  			<tr><input type="text" value="${valuePara.userPasswordString}" name="userpassword"></tr>

  			<!-- <tr><input type="text" value="${valuePara.userRightString}" name="userright"></tr>-->
  			<tr>
  			<select name="userright">
  				
						<!--  <option value="${valuePara.userRightString}" selected="selected">${valuePara.userRightString}</option>-->
						<option value="普通用户" ${valuePara.userRightString eq '普通用户' ? 'selected' : ''}>普通用户</option>
						<option value="设计师" ${valuePara.userRightString eq '设计师' ? 'selected' : ''}>设计师</option>
						<option value="管理员" ${valuePara.userRightString eq '管理员' ? 'selected' : ''}>管理员</option>
  				
  			</select>
  			</tr>
  			<tr><input type="text" value="${valuePara.userAddress}" name="useraddress"></tr>

  			<tr><input type="text" value="${valuePara.userEmailString}" name="useremail"></tr>

  			<tr><input type="text" value="${valuePara.userPhoneNumberString}" name="userphone"></tr>

  			<tr><input type="text" value="${valuePara.userScoreString}" name="userscore"></tr>

  			<tr><input type="text" value="${valuePara.userSex}" name="usersex"></tr>
  			
  			<tr><input type="text" value="${valuePara.userBirthday}" name="userbirthday"></tr>
  			<tr><img src="${valuePara.userIconUrlString}" ><input type="hidden" value="${valuePara.userIconUrlString}" name="usericon"></tr>
  			<tr>
  				<td><input type="reset" value="reset" ></td>
  				<td><input type="submit" value="submit"></td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>
