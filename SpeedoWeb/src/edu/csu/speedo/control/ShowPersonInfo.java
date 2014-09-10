package edu.csu.speedo.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csu.speedo.dao.OrderDao;
import edu.csu.speedo.dao.UserInfoDao;
import edu.csu.speedo.dto.OrderDto;
import edu.csu.speedo.dto.UserDto;

public class ShowPersonInfo extends HttpServlet {

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
		//获取用户id
		int userId = Integer.parseInt(request.getParameter("userId"));
		//获取用户信息
		UserDto userDto = new UserInfoDao().getUserById(userId);
		//获取用户订单列表
		ArrayList<OrderDto> orderDtos = new OrderDao().getAllOrderDtoByUserId(userId);
		//设置到request中
		request.setAttribute("userInfo", userDto);
		request.setAttribute("orderInfo", orderDtos);
		//转发
		request.getRequestDispatcher("").forward(request, response);
		
	}

}
