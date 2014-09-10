<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="edu.csu.speedo.dto.*" %>


<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="author" content="小榛" />
		<link rel="stylesheet" href="css/orderApply.css" type="text/css"
			charset="utf-8" />
		<script language="javascript" src="js/address.js"></script>
		<script src='xk/jquery-1.7.1.js'></script>
		<title>确认订单 - 天喵TMIAO.COM</title>
		<script type="text/javascript">
function inputTextarea(){
	var obj = document.getElementById("olNote");
	obj.className ="on";
	

		obj.innerHtml=" ";   
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

<body onLoad="setup()">
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
						<a target="_self" href="index.jsp"> <img width="150"
								height="50" alt="爱生活，爱设计，我是设计师" src="images/mylogo.png" />
						</a>
					</div>
				</div>
			</div>
			<!-- header -->
			<div id="comm-header">
				<div id="comm-header-inner">
					<img id="cart-logo" src="images/cartlogo.png" />
				</div>
			</div>
			<!-- comm-header -->
			<div id="content">
				<div class="flow-steps">
					<ol class="step-list">
						<li class="done current-prev">
							<span class="first">1.查看购物车</span>
						</li>
						<li class="current">
							<span>2.填写核对信息单</span>
						</li>
						<li class="last">
							<span>3.成功提交订单</span>
						</li>
					</ol>
				</div>
				<!-- flow-steps -->
				<div id="address">
					<form id="addForm" action="/SpeedoWeb/servlet/ApplyOrder"
						name="addForm" method="post">
						<h2>
							确认收货信息
						</h2>
						<ol>
							<li>
								<div>
									<span>*</span> 收&nbsp;货&nbsp;人：&nbsp;
								</div>
								<div>
									<input id="addressee" class="place-holder" type="text" value=""
										placeholder="请准确填写真实姓名" autofocus="true" maxlength="20"
										name="modelFullName" />
								</div>
							</li>
							<li>
								<div>
									<span>*</span> 地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区：&nbsp;
								</div>
								<div>
									<select id="province-id" name="province">
										<option value="">
											--国家--
										</option>
									</select>
								</div>
								<div>
									<select id="city-id" name="city">
										<option value="">
											--省份/直辖市--
										</option>
									</select>
								</div>
								<div>
									<select id="area-id" name="area">
										<option value="">
											--市--
										</option>
									</select>
								</div>
							</li>
							<li>
								<div>
									<span>*</span> 详细地址：
								</div>
								<div>
									<input id="addr-detail" class="addr-detail place-holder"
										type="text" value="" placeholder="请填写详细路名及门牌号" maxlength="80"
										name="modelAddress" />
								</div>
							</li>
							<li>
								<div>
									<span>*</span> 电话号码：
								</div>
								<div>
									<input id="postal-code" class="place-holder" type="number"
										maxlength="20" value="" name="modelPhoneNumber"
										placeholder="请填手机或者座机号码" />
								</div>
							</li>
							<li>
								<div>
									<span>*</span> 邮政编码：
								</div>
								<div>
									<input id="phonenum" class="phone place-holder" type="tel"
										maxlength="6" value="" name="modelPostalCode"
										placeholder="请填写正确的邮政编码" />
								</div>
							</li>
						</ol>
					</form>
				</div>
				<!-- address -->
				<div id="delivery" class="delivery">
					<div class="delivery-hd clearfix">
						<h3 class="delivery-title" data-has-delivery="true">
							配送方式：
						</h3>
						<span> 快递 送货上门（遇到节假日可以能会延时到达）</span>
					</div>
				</div>
				<!-- delivery -->
				<div id="pay" class="pay">
					<div class="pay-hd clearfix">
						<h3 class="pay-title" data-has-delivery="true">
							支付方式：
						</h3>
						<span> 亲~天喵目前只支持&nbsp;<b>货到付款-现金支付</b>&nbsp;哦</span>
					</div>
				</div>
				<!-- pay -->
			</div>
			<!-- content -->
			<div id="goods">
				<form id="J_Form" target="_self" method="post" action="#"
					name="J_Form">
					<div id="goods-list">
						<h2>
							确认订单信息
						</h2>
						<input type="hidden" value="" name="" />
						<input type="hidden" value="" name="" />
						<input type="hidden" value="" name="" />
						<input type="hidden" value="" name="" />
						<input type="hidden" value="" name="" />
						<div id="J_OrderContainer">
							<div>
								<table class="order-table" cellpadding="0" cellpadding="0">
									<tbody class="J_shop">
										<tr class="shop-hd">
											<th class="s-title">
												<img class="site-icon" src="images/littlelogo.png" />
												商品名称
												<hr />
											</th>
											<th class="s-size">
												尺码
												<hr />
											</th>
											<th class="s-price">
												单价（元）
												<hr />
											</th>
											<th class="s-amount">
												数量
												<hr />
											</th>
											<th class="s-total">
												小计（元）
												<hr />
											</th>
										</tr>
										<!-- shop-hd -->
										<c:forEach items="${sessionScope.products}" var='map'>
											<tr class="item">
												<td class="s-title">
													${map.productDto.productName }
												</td>
												<td class="s-size">
													${map.productDto.productSize }
												</td>
												<td class="s-price">
													${map.productDto.productPrice }
												</td>
												<td class="s-amount">
													${map.value }
												</td>
												<td class="s-total">
													${map.productDto.productPrice*map.value }
												</td>
											</tr>
										</c:forEach>
										<tr class="s-shop-otherinfo">
											<td colspan="6">
												<div class="lft">
													<div class="gbook ccc">
														<label class="gbook-title" for="">
															订单备注：
														</label>
														<textarea id="olNote" class="off"
															title="选填，可以告诉我们您对订单的特殊要求." name="olNote"
															onclick="inputTextarea()">选填，可以告诉我们您对订单的特殊要求.</textarea>
													</div>
												</div>
											</td>
										</tr>
										<!-- s-shop-otherinfo -->
									</tbody>
								</table>
							</div>
						</div>
						<!-- J_OrderContainer -->
					</div>
					<!-- goods-list -->
					<div class="J_submitInfo" style="display: block;">
						<div class="point-box">
							<div class="point-in">
								<span id="J_TotalTitle">您总共需要为订单支付：</span>
								<strong id="J_Total_c" class="J_sum_c"
									style="font-family: Arial;">&yen;</strong>
								<strong id="J_Total" class="J_sum">${sessionScope.totalVal
									}</strong>
							</div>
						</div>
						<div class="go-handle">
							<div class="order-go">
								<a id="J-BacktoCart" href="#" target="_top"
									style="display: inline-block;">返回购物车修改</a>
								<button id="J_go" class="J_MakePoint" type="button">
									提交订单
								</button>
							</div>
						</div>
					</div>
					<!-- J_submitInfo -->
				</form>
			</div>
			<!-- goods -->
			<!-------------------footer -------------->

			<div id="footer">
				<div id="speedo-desc">
					<table>
						<tr>
							<td>
								<dl id="ensure">
									<dt>
										<p>
											Speedo保障
										</p>
									</dt>
									<dd>
										<span> &bull; 质量保障 </span>
										<span> &bull; 提供发票 </span>
										<span> &bull; 优质售后 </span>
									</dd>
								</dl>
							</td>
							<td>
								<dl id="beginner">
									<dt>
										<p>
											新手帮助
										</p>
									</dt>
									<dd>
										<span> &bull; 免费注册 </span>
										<span> &bull; 用户协议 </span>
										<span> &bull; 帮助中心 </span>
									</dd>
								</dl>
							</td>
							<td>
								<dl id="payment">
									<dt>
										<p>
											支付方式
										</p>
									</dt>
									<dd>
										<span> &bull; 货到付款 </span>
										<span> &bull; 新人支付 </span>
										<span> &bull; 支付流程 </span>
									</dd>
								</dl>
							</td>
							<td>
								<dl id="go-home">
									<dt>
										<p>
											网站服务
										</p>
									</dt>
									<dd>
										<span> &bull; 设计师须知 </span>
										<span> &bull; 联系我们 </span>
										<span> &bull; 关于我们 </span>
									</dd>
								</dl>
							</td>
						</tr>
					</table>
				</div>
				<div id="copyright">
					<p>
						©2013 speedo小组
					</p>
				</div>
			</div>
			<!-- /#footer -->
		</div>
		<!-- background -->
		<script>
	$('#J_go').click(
			function()
			{if($('#addForm input,select').val()=='')
				{alert('请输入详细信息');
				return false;
				}
			
		$('#addForm').submit();})</script>
	</body>
</html>
