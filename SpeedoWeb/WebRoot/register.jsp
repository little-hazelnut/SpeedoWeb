<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>帐号注册 - 我是设计师</title>
<link rel="stylesheet" href="css/register.css" type="text/css" charset="utf-8" />	
<script type='text/javascript' src='xk/jquery-1.7.1.js'></script>


</head>

<body>
<div id="background">
	<div class="header">
		<div id="logo">
			<a href="index.jsp" ><img src="images/mylogo.png" alt="爱生活，爱设计，我是设计师" width="150" height="50" border="0"/></a>
		</div><!-- /#logo -->
	</div><!-- /.header -->
	<div class="titlebar">
		<div class="titlebar-middle">
			<div class="titlebar-left">
				<span>邮箱注册</span>
			</div>
			<div class="titlebar-right">
				已有帐号？
				<a href="login.html" id="login">马上登陆</a>
			</div>
			<div class="clear"></div>
		</div>
	</div><!-- /.titlebar -->
	<div id="main-content">
		<div id="resgitform">
			<form action="./servlet/ControlReg" method="post">
			<p class="text">
				<label for="rgt-email" class="textbox">邮箱</label>
				<input type="text" name="rgt-email" class="textbox" id="rgt-email"/>
			</p>
			<p class="text">
				<label for="rgt-pwd" class="textbox">密码</label>
				<input type="password" name="rgt-pwd" class="textbox" maxlength="14" id="rgt-pwd"/>
			</p>
			<p class="text">
				<label for="rgt-pwd" class="textbox">重复密码</label>
				<input type="password" name="rgt-pwdAgain" class="textbox" maxlength="14" id="rgt-pwd-again"/>
			</p>
			<p class="text">
				<label for="rgt-verifycode" class="textbox">验证码</label>
				<input type="text" name="verifycode" class="verifycode-text" maxlength="4" id="rgt-verifycode" />
			    <span id="verifycode"><img src="/SpeedoWeb/servlet/CheckCodeImage" alt="验证码图片"  class="rgt-verifyCode" id="rgt-verifyCodeImg" title="验证码图片" /></span>
			</p>
			<p class="protocol">
				<input type="checkbox" name="isAgree" id="rgt-isAgree"  />
				<label for="rgt-isAgree">我已接受并阅读</label><a href="protocol.html">《天喵用户协议书》</a>
			</p>
			<p>
			  <input type="submit" name="rgt-submit" value="加入我们" class="rgt-button" />
			</p>
			</form>
		</div><!-- /#resgitform -->
	</div><!-- /#main-content -->
	<div id="footer">
	<p style="font-size:15px">©2013 speedo小组</p>
	</div><!-- /#footer -->
</div><!-- /#background -->
	<script type='text/javascript'>$(document).ready(
	function()
	{
	$('#rgt-email').blur(function(){$.post(
  "servlet/Ncheck",{usen:$('#rgt-email').val()},
  function(data){
  if(data=='true')
  {if(!document.getElementById('warn')){
  $('<font color=red id=warn>对不起用户名已被占用，请换个用户名</font>').insertAfter('#rgt-email');
  $('input[type=submit]').attr("disabled","disabled");}
  }
  else{  $('input[type=submit]').removeAttr("disabled");$('#warn').remove();}}
  )
  }
);}); 
(function (){
$('#rgt-pwd-again').blur(function(){if($('#rgt-pwd-again').val()!=$('#rgt-pwd').val()){

if(!document.getElementById('warn1')){
$('<font color=red id=warn1>两次密码不一致，请重新输入</font>').insertAfter('#rgt-pwd-again');}}else{
$('#warn1').remove();}})
})();
  </script>
  <script type="text/javascript">
$('#rgt-verifycode').blur(
		function(){
			$.post(
					'servlet/CheckCode',{code:$('#rgt-verifycode').val()},function(data){
					//	alert(data);
					//var s=data.substring(0,data.indexof(''));
						if(data.trim()=='good'){$('#rgt-verifycode').after('<font color=red id=warn2 size=3px>验证码错误，请重新输入</font>');$('input[type=submit]').attr("disabled","disabled");}else{
							$('#warn2').remove();$('input[type=submit]').removeAttr("disabled");}})})
</script>
</body>
</html>
