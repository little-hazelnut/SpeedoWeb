<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="edu.csu.speedo.dto.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>

<html>
<head>

<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>商城 - 天喵TMIAO.COM</title>
	<link rel="stylesheet" href="/SpeedoWeb/css/style.css" type="text/css" charset="utf-8" />
	<link rel="stylesheet" href="/SpeedoWeb/css/shop.css" type="text/css" charset="utf-8" />		

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
		<script src='xk/jquery-1.7.1.js'></script>
</head>

<body>
	<div id="background">
		<div id="header">
			<div id="inner-header">
				<span id="connect">
					<a href="index.jsp" target="_self">
						<img width="150" height="50" src="images/mylogo.png" alt="爱生活，爱设计，我是设计师">
					</a>
				</span>

			<%  if( login!=null){  %>
					<span id="infos-hidden">
						<span>HI,&nbsp;${sessionScope.user.userNameString}！&nbsp;</span>
						<a href="/SpeedoWeb/servlet/ControlLogout">退出</a>|
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

			</div><!-- inner-header -->
		</div> <!-- /#header -->
		<div id="navigation-div">
			<div id="inner-nav">
				<ul id="navigation">
					<li class="li-index"><a href="index.jsp">主页</a></li>
					<li class="li-shop selected"><a href="servlet/ListProduct">商城</a></li>
					<li class="li-blog"><a href="servlet/ListPicture">设计师作品</a></li>
					<li class="li-diy-work"><a href="diy-work.jsp">自己设计</a></li>
					<li class="li-imageswall"><a href="imageswall/imageswall.html">天喵照片墙</a></li>
					<li class="about"><a href="about.html">关于我们</a></li>
					<li class="contact-us"><a href="contact-us.html">联系我们</a></li>
				</ul>
			</div>
		</div><!-- navigation-div -->
		<div id="page">
			<div id="contents">
				<div id="shop">
					<ul class="items">
					<c:forEach items="${requestScope.productList}" var="productList">
					<li>
							<div class="pro-img">
								<a href="/SpeedoWeb/ShowPro?id=${productList.productId} ">
									<img src="${productList.imgSrc}" alt="shirt" />
								</a>
							</div>
							<div class="pro-txt">
								<a href="#">${productList.productName}</a>
							</div>
							<div class="pro-price-men">
								${productList.productPrice} 
							</div>
						</li></c:forEach>
						
					</ul>
					<div class="allpages">
						<a class="curpage" href="/SpeedoWeb/servlet/ListProduct?index=1">1</a>
						<a href="/SpeedoWeb/servlet/ListProduct?index=2">2</a>
						<a href="/SpeedoWeb/servlet/ListProduct?index=3">3</a>
						<a href="/SpeedoWeb/servlet/ListProduct?index=4">4</a>
						<a href="/SpeedoWeb/servlet/ListProduct?index=5">5</a>
						<a href="#">...</a>
						<a class="nextpageurl" href="#">下一页</a>
					</div>
				</div>
			</div> <!-- /#contents -->
			<div id="footer">
				<div id="description">
					<div>
						<a href="index.jsp" class="logo">
							<img src="images/tmiao-footer.jpg" />
						</a>
						<span>&copy; Copyright &copy; 2013. <a href="index.html">Speedo team</a> All rights reserved</span>
					</div>
					<p>有一根火柴，它走在路上，走呀走，走呀走，走呀走呀走呀走……它忽然觉得头痒，于是它就挠呀挠， 挠呀挠，挠呀挠呀挠呀挠……後来....後来它把自己烧著了，最後灭了~~~ </p>
					<p>	小榛：为什么小红帽是平胸？ 小喵：为什么呀！ 小榛：因为她奶奶被大灰狼吃了...= =！</p>
				</div>
				<div class="navigation">
					<a href="index.jsp">Home</a>|
					<a href="shop.jsp">Shop</a>|
					<a href="blog.jsp">Blog</a>|
					<a href="about.html">About</a>|
					<a href="contact-us.html">Contact Us</a>
				</div>
			</div> <!-- /#footer -->
		</div> <!-- /#page -->
	</div> <!-- /#background -->
</body>
<script>$('.allpages').children().removeAttr('class');
${requestScope.id};
$('.allpages').children().eq(${requestScope.id}-1).addClass('curpage');</script>
</html>
