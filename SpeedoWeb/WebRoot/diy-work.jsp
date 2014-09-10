<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="edu.csu.speedo.dto.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content ="小榛"/>
<link rel="stylesheet" href="css/diy-work.css" type="text/css" charset="utf-8" />	
<title>作品上传 - 天喵TMIAO.COM</title>
<script src='xk/jquery-1.7.1.js'></script>
<script>      
	function viewmypic(mypic,imgfile) { 
			document.getElementById("showimg").src= getFullPath(imgfile);     
	}  
	
	function getFullPath(obj)
     {
          if(obj)
          {
           	  //ie
            	 if (window.navigator.userAgent.indexOf("MSIE")>=1)
                	{
                   		 obj.select();
                   		 return document.selection.createRange().text;
                	}
                //firefox
                else if(window.navigator.userAgent.indexOf("Firefox")>=1)
              	 {
                    if(obj.files)
                    {
                        return window.URL.createObjectURL(obj.files[0]);
                    }
                    	return obj.value;
                }
                return obj.value;
            }
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
		<div id="site-nav">
			<div class="nav-middle">

				<p id="login-info-right">
				
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
					
					
				</p>
			</div>
		</div><!-- site-nav -->
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
				<img id="cart-logo" src="images/DIY_logo.png" />		
			</div>
		</div><!-- comm-header -->
		<div id="content">
			<div id = "diy-left-content">
				<fieldset class="img-view-field">
					<legend>图片预览</legend>
					<img name="showimg" id="showimg" src="images/worksupload-adv.jpg" alt="预览图片" />
				</fieldset>
				<p>爱生活，爱设计，我是喵星人</p>
				<fieldset class="imgwall-field">
					<legend>天猫照片墙 - 寻找我们的印记</legend>
					<div align="center">
						<a href="imageswall/imageswall.html">
							<img src="images/image-adv.jpg"/>
						</a>
					</div>
				</fieldset>
			</div>
			<div id = "diy-right-content">
				<form action="/SpeedoWeb/servlet/UploadFile" method="post" enctype="multipart/form-data"> 
					<h1>分享您的作品</h1>
					<div class="viewmypic">
					   	<label>作品</label><br />
						<input name="imgfile" type="file" id="imgfile" size="40" onchange="viewmypic(showimg,this)" />
					</div>
					<div class="work-info">
						<fieldset class="info-field">
							<legend><p class="work-info-title">请填写作品信息</p></legend>
							<p>
								<label>作品标题</label>
								<br />
								<input id="work-title" class="work-title" type="text" value="" placeholder="请填写标题" autofocus="true" maxlength="20" name="worktitle" />
								<span class="red">(必填)</span>
							</p>
							<div class="title-tip">
								 例：
								 <b>可爱的喵喵带英文love情侣时尚个性</b>
								 <br>
								 好的图案命名能够方便客户从海量图案中搜索到您的图案，提高您的图案展现频率，
								 <span class="red">促成您的图案成交概率</span>
								。所以建议您认真命名上传图案，在作品名或作品介绍里尽可能多用关键字描述。 
							</div>
							<p>
								<label>作品说明</label><br />
								<textarea id="work-description" class="description-text" name="designs_about" cols="40" rows="6"></textarea>
								<span class="red">(重要)</span>
							</p>
							<p>
								<label>薪酬</label>
								<span>&nbsp;&nbsp;&nbsp;订单金额的10%</span>
							</p>
							<p>
								<label>标签</label>
							</p>						
							<div class="works-tag">
								<label>爱情</label>
								<label>卡通</label>
								<label>非主流</label>
								<label>重口味</label>
								<label>小清新</label>
								<label>流行</label>
								<label>影视</label>
								<label>音乐</label>
								<label>体育</label>
								<label>儿童</label>
								<label>屌丝</label>
								<label>女神</label>
							</div> 
							<p class="promise">
								<label>声明&nbsp;&nbsp;&nbsp;</label>
								<input id="my-promise-id" type="checkbox" checked="checked" name="my-promise" />
								<label for="my-promise-id" class="red">
									我上传的作品是我原创的作品或者已经过版权保护期的公共作品，该作品不会给任何个人和组织带来任何伤害。
								</label>
							</p>
						</fieldset>	
					</div><!-- worksinfo -->

					<div class="submit-div">
						<p>
						 	<input class="submit-button" type="submit" value="提交设计作品"/>
						</p>
					</div>   
				</form>      
			</div>
		</div><!--  content  -->
		<div id="copyright">
			<p>©2013 speedo小组</p>
		</div>
	</div>

</body>
	<script>
	var login=<%=login %>;
	
	$('.submit-button').click(function(){
if(login==null){alert('请先登录');return false;}
})
		
	</script>
</html>
