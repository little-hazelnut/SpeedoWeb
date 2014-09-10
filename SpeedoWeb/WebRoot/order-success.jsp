<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="edu.csu.speedo.dto.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content ="小榛"/>
<link rel="stylesheet" href="css/order-success.css" type="text/css" charset="utf-8" />
<title>成功提交订单 - 天喵TMIAO.COM</title>

		<% String login = null; %>
	
		<%
		System.out.println(session.getId());
		System.out.println(session.getAttribute("login"));
			if(session.getAttribute("login")!=null ){
			login=session.getAttribute("userName").toString();
				 System.out.println(login);
			}
			else{
				login =null;
			}
		%>

</head>

<body>
	<div id="background">
		<div id="site-nav">
			<div class="nav-middle">
				<p id="login-info-right">
	
				<%  if( login!=null){  %>
				<span id="infos-hidden">
					<span>HI,&nbsp;${sessionScope.user.userNameString}！&nbsp;</span>
					<a href="SpeedoWeb/servlet/ControlLogout">退出</a>|
					<a href="servlet/GetProduct">购物车</a>
				</span>
				<%} else { %>
				<span id="infos">
					<span>欢迎来天喵！</span>
					<a href="login.html">请登陆</a>
					<a href="register.jsp">免费注册</a>|
					<a href="servlet/GetProduct">购物车</a>
				</span>
				<% } %>
	
				</p>
			</div>
		</div>
		<div id="header">
			<div id="header-inner">
				<div class="logo">
					<a target="_self" href="index.jsp">
						<img width="150" height="50" alt="爱生活，爱设计，我是设计师" src="images/mylogo.png" /></a>
				</div>
			</div>
		</div><!-- header -->
		<div id="comm-header">
			<div id="comm-header-inner">
				<img id="cart-logo" src="images/cartlogo.png" />
			</div>
		</div><!-- comm-header -->
		<div id="content">
			<div class="flow-steps">
				<ol class="step-list">
					<li class="done">
						<span class="first">1.查看购物车</span></li>
					<li class="done">
						<span>2.填写核对信息单</span></li>
					<li class="current">
						<span>3.成功提交订单</span></li>
				</ol>
			</div><!-- flow-steps -->
			</div>
			<div class="apply-success">
				<div class="apply-info">
					<img class="apply-img" src="images/applysuccess.jpg" title="success" alt="picture"/>
					<p class="apply-text">恭喜，订单提交成功了！我们会尽快为您处理...</p>
					<p>
						<label>订单号：</label>
						<span id="order-num">${requestScope.order.orderId} </span>
						<label>,您需要支付：</label>
						<span id="order-total">${requestScope.order.totalPrice} 元</span>
					</p>
				</div>
			</div>
			<div class="TM-advise">
				<p>天喵为您推荐：</p>
				<div class="img-walls-adv">
					<fieldset class="ad-fs">
						<legend>天喵照片墙</legend>
						<a href="imageswall/imageswall.html" title="天喵照片墙"><img src="images/imgwall-adv2.jpg"  /></a>
					</fieldset>
				</div>
			<div>	
			<!-------------------footer -------------->
			<div id="footer">
				<div id="speedo-desc">
					<table>
					<tr>
					<td><dl id="ensure">
						<dt>
							<p>Speedo保障</p>
						</dt>
						<dd>
							<span>
								&bull;
								质量保障
							</span>
							<span>
								&bull;
								提供发票
							</span>
							<span>
								&bull;
								优质售后
							</span>
						</dd>
					</dl></td>	
					<td><dl id="beginner">
						<dt>
							<p>新手帮助</p>
						</dt>
						<dd>
							<span>
								&bull;
								免费注册
							</span>
							<span>
								&bull;
								用户协议
							</span>
							<span>
								&bull;
								帮助中心
							</span>
						</dd>
					</dl></td>
					<td><dl id="payment">
						<dt>
							<p>支付方式</p>
						</dt>
						<dd>
							<span>
								&bull;
								货到付款
							</span>
							<span>
								&bull;
								新人支付
							</span>
							<span>
								&bull;
								支付流程
							</span>
						</dd>
					</dl></td>
					<td><dl id="go-home">
						<dt>
							<p>网站服务</p>
						</dt>
						<dd>
							<span>
								&bull;
								设计师须知
							</span>
							<span>
								&bull;
								联系我们
							</span>
							<span>
								&bull;
								关于我们
							</span>
						</dd>
					</dl></td></tr></table>
				</div>	
				<div id="copyright">
				<p>©2013 speedo小组</p>
				</div>
			</div><!-- /#footer -->
		</div><!-- content -->
	</div><!-- background -->
	</div>
</body>
</html>