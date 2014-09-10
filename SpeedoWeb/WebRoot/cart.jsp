<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="edu.csu.speedo.dto.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta name="author" content ="小榛"/>
<link rel="stylesheet" href="/SpeedoWeb/css/cart.css" type="text/css" charset="utf-8" />
<title>购物车- 天喵TMIAO.COM</title>

<script src='/SpeedoWeb/xk/jquery-1.7.1.js'></script>

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
		</div>
		<div id="header">
			<div id="header-inner">
				<div class="logo">
					<a target="_self" href="/SpeedoWeb/index.jsp">
						<img width="150" height="50" alt="爱生活，爱设计，我是设计师" src="/SpeedoWeb/images/mylogo.png" /></a>
				</div>
			</div>
		</div><!-- header -->
		<div id="comm-header">
			<div id="comm-header-inner">
				<img id="cart-logo" src="/SpeedoWeb/images/cartlogo.png" />
			</div>
		</div><!-- comm-header -->
		<div id="content">
			<div class="flow-steps">
				<ol class="step-list">
					<li class="current">
						<span class="first">1.查看购物车</span></li>
					<li class="last">
						<span>2.填写核对信息单</span></li>
					<li class="last">
						<span>3.成功提交订单</span></li>
				</ol>
			</div><!-- flow-steps -->
			<div id="cart">
				<table id="T_Cart" class="cart-table" cellpadding="0">
					<colgroup valign="middle">
						<col width="62" /> 		<!-- select -->
						<col />					<!-- product-name -->
						<col width="70" />		<!-- size -->
						<col width="100" />		<!-- price -->
						<col width="70" />		<!-- num -->
						<col width="116" />		<!-- sum -->
						<col width="56" />		<!-- del -->
					</colgroup>
					<thead>
						<tr>
							<th class="s-chk"></th>
							<th class="s-title">
								<img class="site-icon" src="images/littlelogo.png"/>
								商品名称
							</th>
							<th class="s-size">尺码</th>
							<th class="s-price">单价（元）</th>
							<th class="s-amount">数量</th>
							<th class="s-total">小计（元）</th>
							<th class="s-del"></th>
						</tr>
					</thead>
					<tbody id="cart-content">
					<c:forEach items="${sessionScope.products}" var='map'>
					<tr class="cart-item">
							<td class="s-chk">
								<input class="m-col-chk" type="checkbox" checked="checked"/>
							</td>
							<td class="s-title">${map.productDto.productName } </td>
							<td class="s-size">${map.productDto.productSize } </td>
							<td class="s-price">${map.productDto.productPrice }</td>
							<td class="s-amount">${map.value }</td>
							<td class="s-total">${map.productDto.productPrice * map.value}</td>
							<td class="s-del">
								<input type="button" value="删除" class='del'/><input type="hidden" value='${map.productDto.productId}'/>
							</td>	
							
						</tr></c:forEach>
					</tbody>
				</table>
			</div><!-- cart -->
			<div id="cert-finish">
				<div id="cashier">
					<div class="cashier-left">
						<span>
							<label>
								<input class="m-chk-all" type="checkbox" checked="checked" />
								全选
							</label>						
						</span>
						<span>
							<label>
								<input type="button" value="批量删除" class="m-chk-del"/>
							</label>
						</span>				
					</div><!-- cashier-left -->
					<div class="cashier-right">
						<span class="m-fee-box">
							商品合计（不含运费）：
							<em class="m-total-fee"></em>
						
							元
						</span>
						<span class="m-go-box">
							<button class="m-go" type="button">去结算</button>
						</span>			
					</div><!-- cashier-right -->
				</div><!-- cashier -->
			</div><!-- cert-finish -->
			<div class="TM-advise">
				<p>天喵为您推荐：</p>
				<div class="img-walls-adv">
					<fieldset class="ad-fs">
						<legend>天喵照片墙</legend>
						<a href="/SpeedoWeb/imageswall/imageswall.html" title="天喵照片墙"><img src="/SpeedoWeb/images/imgwall-adv2.jpg"  /></a>
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
	</div>
<script type='text/javascript'>

//提交商品到servlet，防止有修改信息
$('.m-go').click(
function(){
window.location.href='/SpeedoWeb/servlet/GetProduct?a=1';})



//开始前计算单价
$(document).ready(function(){
var pri=0; for(var i=0;i<$('.cart-item').size();i++){pri+=parseInt($('.cart-item').eq(i).children('td').eq(5).html());}
$('.m-total-fee').html(pri);})

//删除按钮的功能，目前session删除但是无效果
$('.del').click(
function(){

$('.m-total-fee').html(parseInt($('.m-total-fee').html())-parseInt($(this).parent().prev().html()));
$(this).parents('.cart-item').remove();
$.post(
'/SpeedoWeb/servlet/ajaxcart',{data:$(this).next().val()})
})


</script>
</body>
</html>