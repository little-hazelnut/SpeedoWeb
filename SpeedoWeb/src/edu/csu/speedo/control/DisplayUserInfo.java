package edu.csu.speedo.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csu.speedo.dao.UserInfoDao;
import edu.csu.speedo.dto.UserDto;

public class DisplayUserInfo extends HttpServlet {

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

		System.out.println("inner DisplayUserInfo");
		UserDto userDto = new UserDto();
		int userId = Integer.parseInt(request.getParameter("valuePara"));
		System.out.println(userId);
		UserInfoDao userInfoDao = new UserInfoDao();
		System.out.println(userInfoDao.getUserById(userId));
		userDto = userInfoDao.getUserById(userId);
		request.setAttribute("valuePara", userDto);
		request.getRequestDispatcher("/UserEdit.jsp").forward(request, response);
	}

}
