<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'baket.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type='text/javascript'  src='jquery-1.7.1.js'></script>

  </head>
  
  <body>
  <input type=text name='item'>
  <input type=text name='num'>
   <input id='a' type='button'  class='add' value='添加到购物车' /> <br>
  </body>
  <script type='text/javascript'>
$('.add').click(
function(event){
var obj;
	if(event.srcElement)
obj=event.srcElement;
	else obj=event.target;
	$.post(
	"/SpeedoWeb/baket",
{num:$(obj).prev().val(), item:$(obj).prev().prev().val()},
	function(data){alert("ok");});
	}
)
</script>
</html>
