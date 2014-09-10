<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>

<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>作品详情 - 天喵TMIAO.COM</title>
		<link rel="stylesheet" href="css/style.css" type="text/css"
			charset="utf-8" />
		<link rel="stylesheet" href="css/designer-work.css" type="text/css"
			charset="utf-8" />
		<script src='xk/jquery-1.7.1.js'></script>
		<script type="text/javascript">
	
	var score = 0;
	
	function starAppear(starNum){
			
			if(score != 0)
				return;
			
			
			if(starNum==1)
			{
				document.getElementById("star1").className="sprite-star";
				document.getElementById("star2").className="sprite-star-null";
				document.getElementById("star3").className="sprite-star-null";
				document.getElementById("star4").className="sprite-star-null";
				document.getElementById("star5").className="sprite-star-null";
			}
			
			if(starNum==2)
			{
				document.getElementById("star1").className="sprite-star";
				document.getElementById("star2").className="sprite-star";
				document.getElementById("star3").className="sprite-star-null";
				document.getElementById("star4").className="sprite-star-null";
				document.getElementById("star5").className="sprite-star-null";
			}
			
			if(starNum==3)
			{
				document.getElementById("star1").className="sprite-star";
				document.getElementById("star2").className="sprite-star";
				document.getElementById("star3").className="sprite-star";
				document.getElementById("star4").className="sprite-star-null";
				document.getElementById("star5").className="sprite-star-null";
			}
			
			if(starNum==4)
			{
				document.getElementById("star1").className="sprite-star";
				document.getElementById("star2").className="sprite-star";
				document.getElementById("star3").className="sprite-star";
				document.getElementById("star4").className="sprite-star";
				document.getElementById("star5").className="sprite-star-null";
			}
			
			if(starNum==5)
			{
				document.getElementById("star1").className="sprite-star";
				document.getElementById("star2").className="sprite-star";
				document.getElementById("star3").className="sprite-star";
				document.getElementById("star4").className="sprite-star";
				document.getElementById("star5").className="sprite-star";
			}
		
	}

	function clearStar(){
	
			if(score != 0)
				return;
		
			document.getElementById("star1").className="sprite-star-null";
			document.getElementById("star2").className="sprite-star-null";
			document.getElementById("star3").className="sprite-star-null";
			document.getElementById("star4").className="sprite-star-null";
			document.getElementById("star5").className="sprite-star-null";	
		
	}
	
	function selectScore(selectNum){
	
		if(score != 0)
			return;
		score = selectNum;
		document.getElementById("score-rs").style.display="block";
		document.getElementById("u-score").innerHTML = score+"分";
		
	
	
	}
	
</script>

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
		<div id="header">
			<div id="inner-header">
				<span id="connect">
					<a href="index.jsp" target="_self">
						<img width="150" height="50" src="images/mylogo.png" alt="爱生活，爱设计，我是设计师">
					</a>
				</span>
	
				<% System.out.println(login); if( login!=null){  %>
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
					<li class="li-shop"><a href="servlet/ListProduct">商城</a></li>
					<li class="li-blog"><a href="servlet/ListPicture">设计师作品</a></li>
					<li class="li-diy-work"><a href="diy-work.jsp">自己设计</a></li>
					<li class="li-imageswall"><a href="imageswall/imageswall.html">天喵照片墙</a></li>
					<li class="about"><a href="about.html">关于我们</a></li>
					<li class="contact-us"><a href="contact-us.html">联系我们</a></li>
				</ul>
			</div>
			<!-- navigation-div -->
			<div id="page">
				<div id="contents">
					<div id="blogs">
						<div class="pro-info">
							<div class="pro-pic">
								<img src="${requestScope.picture.imgSrc}" alt="shirt" />
							</div>
							<div class="pro-style">
								<div class="pro-style-content">
									<h3>
										${requestScope.picture.pictureName}
									</h3>
									<div class="designer-name">
										<em>设计师：</em>
										<span id="designer-name">${requestScope.picture.userName}</span>
									</div>
									<div class="pro-description">
										<em>设计师描述：</em>
										<span id="pro-description">
											${requestScope.picture.description } </span>
									</div>
								</div>
								<div class="all-score">
									<div class="t-score">
										<label>
											用户评分：
										</label>
										<span class="sprite-star"></span>
										<span class="sprite-star"></span>
										<span class="sprite-star"></span>
										<span class="sprite-star"></span>
										<span class="sprite-star"></span>
									</div>
									<div class="my-score">
										<label>
											我的评分：
										</label>
										<span class="sprite-star-null" id="star1"
											onMouseOver="starAppear(1)" onMouseOut="clearStar()"
											onClick="selectScore(1)"></span>
										<span class="sprite-star-null" id="star2"
											onMouseOver="starAppear(2)" onMouseOut="clearStar()"
											onClick="selectScore(2)"></span>
										<span class="sprite-star-null" id="star3"
											onMouseOver="starAppear(3)" onMouseOut="clearStar()"
											onClick="selectScore(3)"></span>
										<span class="sprite-star-null" id="star4"
											onMouseOver="starAppear(4)" onMouseOut="clearStar()"
											onClick="selectScore(4)"></span>
										<span class="sprite-star-null" id="star5"
											onMouseOver="starAppear(5)" onMouseOut="clearStar()"
											onClick="selectScore(5)"></span>
									</div>
									<div id="score-rs" class="score-rs">
										<label>	您的评分是:</label>
										<span id="u-score">5</span>
									</div>
								</div>
								<!--- all-score -->
								<div class="t-total">

									<div class="shoppingBox">
									<!--  	<input type="button" class="add-cart" value="去购买" />-->

									<div style="clear:both;">

									</div>
								</div>
								<!-- t-total -->
							</div>
							<!-- pro-style-content -->
						</div>
						<!--	pro-style -->
						<div style="clear: both"></div>
					</div>
					<!-- pro-info -->
					<div style="clear: both;">
					</div>
					<div class="pro-comment">
						<div class="user-comment">
							<h3>
								喵星人评论：
							</h3>
							<ul>
								<li>
									<em>小榛：</em>一只黑猫把一只白猫从河裏救起来了,你知道後来那白猫对黑猫说什麽吗?它说：“喵——”
								</li>
								<li>
									<em>小榛：</em>一只黑猫把一只白猫从河裏救起来了,你知道後来那白猫对黑猫说什麽吗?它说：“喵——”
								</li>
								<li>
									<em>小榛：</em>一只黑猫把一只白猫从河裏救起来了,你知道後来那白猫对黑猫说什麽吗?它说：“喵——”
								</li>
								<li>
									<em>小榛：</em>一只黑猫把一只白猫从河裏救起来了,你知道後来那白猫对黑猫说什麽吗?它说：“喵——”
								</li>
							</ul>
						</div>
						<div class="my-comment-box">
							<textarea id="my-comment">我的评价...</textarea>
							<input id="comment-share" class="comment-button" type="button"
								value="发表" />
						</div>

						<div style="clear: both"></div>
					</div>
					<!-- pro-comment -->

						<div style="clear:both"></div>
					</div><!-- pro-comment -->
				</div><!-- content -->
			<div id="footer">
				<div id="description">
				  	<div>
					  <a href="index.jsp" class="logo"></a>
					  <span>&copy; Copyright &copy; 2013. <a href="index.html">speedo team</a> All rights reserved</span>
        		  	</div>
				  	<p>有一根火柴，它走在路上，走呀走，走呀走，走呀走呀走呀走……它忽然觉得头痒，于是它就挠呀挠， 挠呀挠，挠呀挠呀挠呀挠……後来....後来它把自己烧著了，最後灭了~~~ </p>
					<p>	小榛：为什么小红帽是平胸？ 小喵：为什么呀！ 小榛：因为她奶奶被大灰狼吃了...= =！</p>

				</div>

				<!-- content -->
				
					<div class="navigation">
						<a href="index.html">Home</a>|
						<a href="about.html">About</a>|
						<a href="blog.html">Blog</a>|
						<a href="shop.html">Shop</a>|
						<a href="contact-us.html">Contact Us</a>
					</div>

				<!-- /#footer -->
			</div>
			<!-- /#page -->
		</div>
		<!-- /#background -->
		<script>
	$('.sprite-star-null').bind("click",function(){$.post(
'servlet/NewPicCom',{"userId":${requestScope.picture.userId},
	"picId":${requestScope.picture.pictureId},
	"com":$('#score-rs label').text()+$('#u-score').text(),
	"comS":$(this).index()},
	function(){
	$('.sprite-star-null').unbind("click");	
})})





		</script>
	</body>
</html>