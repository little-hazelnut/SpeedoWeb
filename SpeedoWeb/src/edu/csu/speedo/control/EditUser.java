package edu.csu.speedo.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csu.speedo.dao.UserInfoDao;
import edu.csu.speedo.dao.UserRightDao;
import edu.csu.speedo.dto.UserDto;

public class EditUser extends HttpServlet {

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
		
		System.out.println("inner EditUser");
		UserDto userDto = new UserDto();
		int userId = Integer.parseInt(request.getParameter("userid"));
		System.out.println(userId);
		//通过用户Id在数据库中拿到用户对象
		UserInfoDao userInfoDao = new UserInfoDao();
		userDto = userInfoDao.getUserById(userId);
		//userDto.setUserId(Integer.parseInt(request.getParameter("userid")));
		//userDto.setUserNameString(request.getParameter("username"));
		userDto.setUserPasswordString(request.getParameter("userpassword"));
		userDto.setUserRightString(request.getParameter("userright"));
		userDto.setUserAddress(request.getParameter("useraddress"));
		//userDto.setUserEmailString(request.getParameter("useremail"));
		userDto.setUserPhoneNumberString(request.getParameter("userphone"));
		userDto.setUserScoreString(request.getParameter("userscore"));
		userDto.setUserSex(request.getParameter("usersex"));
		//System.out.println(request.getParameter("usersex"));
		userDto.setUserBirthday(Date.valueOf(request.getParameter("userbirthday")));
		userDto.setUserIconUrlString(request.getParameter("usericon"));

		userInfoDao.updateUserById(userDto, userId);
	}

}
