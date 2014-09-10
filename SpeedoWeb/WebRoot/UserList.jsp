<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UserList.jsp' starting page</title>
    
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
  <table border="1">
  	<thead>
  		<tr>
  			<td>Id</td>
  			<td>Name</td>
  			<td>Password</td>
  			<td>UserRight</td>
  			<td>Address</td>
  			<td>Email</td>
  			<td>Phone</td>
  			<td>Score</td>
  			<td>Sex</td>
  			<td>Birthday</td>
  			<td>Img</td>
  			<td>操作</td>
  		</tr>
  	</thead>
  	<tbody>
  		<c:forEach items="${userlist}" var="userlist">
  		<tr>
  		  	<td>${userlist.userId}</td>
  			<td>${userlist.userNameString}</td>
  			<td>${userlist.userPasswordString}</td>
  			<td>${userlist.userRightString}</td>
  			<td>${userlist.userAddress}</td>
  			<td>${userlist.userEmailString}</td>
  			<td>${userlist.userPhoneNumberString}</td>
  			<td>${userlist.userScoreString}</td>
  			<td>${userlist.userSex}</td>
  			<td>${userlist.userBirthday}</td>
  			<td><img src="${userlist.userIconUrlString}" ></td>
  			<td><a href="${basePath}servlet/RequestForward?destPara=DelUser&valuePara=${userlist.userId}">删除</a> <a href="${basePath}servlet/RequestForward?destPara=DisplayUserInfo&valuePara=${userlist.userId}" >修改</a></td>
  			</tr>
  		</c:forEach>
  	</tbody>
  </table>
  </body>
</html>
