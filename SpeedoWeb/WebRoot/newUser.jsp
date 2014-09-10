<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'newUser.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type='text/javascript' src='xk/jquery-1.7.1.js'></script>

	</head>

	<body>
		This is my JSP page.
		<br>
		<form action="./servlet/ControlReg" method="post"
			enctype="multipart/form-data">
			Email:
			<input type="text" name="email">
			<br>
			UserName:
			<input type="text" id='use' name="username">
			<br>
			Password:
			<input type="password" name="password">
			<br>
			repeatPassword:
			<input type="password" name="repassword">
			<br>
			img:
			<input type="file" name="myfile">
			<br>
			<input type="reset" value="Reset">
			<input type="submit" value="submit">
		</form>
	</body>
	<script type='text/javascript'>$(document).ready(
	function()
	{
	$('#use').blur(function(){$.post(
  "servlet/Ncheck",{usen:$('#use').val()},
  function(data){
  if(data=='true')
  {alert('ok');
  $('<font color=red>对不起用户名已被占用，请换个用户名</font>').insertAfter('#use');
  $('input[type=submit]').attr("disabled","disabled");
  }
  else{  $('input[type=submit]').removeAttr("disabled");}}
  )
  }
);}); 
  </script>
</html>
