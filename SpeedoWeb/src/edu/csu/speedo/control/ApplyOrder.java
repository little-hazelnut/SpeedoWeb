package edu.csu.speedo.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csu.speedo.dao.OrderDao;
import edu.csu.speedo.dao.OrderInfoDao;
import edu.csu.speedo.dao.ProductDao;
import edu.csu.speedo.dto.OrderDto;
import edu.csu.speedo.dto.OrderInfoDto;
import edu.csu.speedo.dto.UserDto;

public class ApplyOrder extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//生成OrderId
		int orderId = (int) (System.currentTimeMillis() / 1000);
		//定义transportId
		Integer transportId = orderId;
		//设置订单完成标志位
		byte tag = 0;
		//定义订单总价变量
		int totalPrice = 0;
		// 从session中获取购物车信息
		HashMap<String, Integer> thing = (HashMap<String, Integer>) request
				.getSession().getAttribute("goods");
		// 遍历hashMap,构造orderInfoDto存入数据库,计算总结
		Iterator iter = thing.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
			// 通过productId获取productPrice
			int productPrice = new ProductDao().getProductById(
					Integer.parseInt(key.toString())).getProductPrice();
			totalPrice += productPrice * Integer.parseInt(val.toString());
			System.out.println(totalPrice);
			// 构造orderInfoDto
			OrderInfoDto orderInfoDto = new OrderInfoDto();
			orderInfoDto.setOrderId(orderId);
			System.out.println(orderId);
			orderInfoDto.setProductId(Integer.parseInt(key.toString()));
			System.out.println(key.toString());
			orderInfoDto.setCount(Integer.parseInt(val.toString()));
			System.out.println(val.toString());
			//if (new OrderInfoDao().addOrderInfo(orderInfoDto) == 1)
			new OrderInfoDao().addOrderInfo(orderInfoDto);
				System.out.println("OrderInfo添加成功");
		}
		System.out.println(totalPrice);
		//从session中获取提交订单的用户信息
		UserDto userDto = (UserDto) request.getSession().getAttribute("user");
		int userId = userDto.getUserId();
		System.out.println(userId);
	
		
		//从页面request中获取订单信息
		String destination  = "中国湖北黄冈英山";
	
		System.out.println(destination);
		//String orderName = "馨馨";
		String orderName = request.getParameter("modelFullName");
		System.out.println(orderName);
		int zipCode = Integer.parseInt(request.getParameter("modelPostalCode"));
		System.out.println(zipCode);
		String phoneNumber =  request.getParameter("modelPhoneNumber");
		System.out.println(phoneNumber);
		String orderDescription = null;
		
		//构造OrderDto
		OrderDto orderDto  = new OrderDto();
		orderDto.setOrderId(orderId);
		orderDto.setPhoneNumber(phoneNumber);
		orderDto.setTotalPrice(totalPrice);
		orderDto.setOrderUserId(userId);
		orderDto.setOrderDate(new Date(System.currentTimeMillis()));
		orderDto.setTransportId(transportId.toString());
		orderDto.setDestination(destination);
		orderDto.setOrderCompeleteTag(tag);
		orderDto.setOrderDescription(orderDescription);
		orderDto.setOrderName(orderName);
		orderDto.setOrderZip(zipCode);
		//构造OrderDao
		OrderDao orderDao = new OrderDao();
		if(orderDao.addOder(orderDto) == 1)
			System.out.println("订单提交成功");
		request.setAttribute("order", orderDto);
request.getRequestDispatcher("/order-success.jsp").forward(request, response);
	}

}
