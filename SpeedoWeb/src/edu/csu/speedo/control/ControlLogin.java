package edu.csu.speedo.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.csu.speedo.dao.UserInfoDao;
import edu.csu.speedo.dto.UserDto;

public class ControlLogin extends HttpServlet {

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
		String  userEmail = request.getParameter("login-email");
		String userPassword = request.getParameter("login-pwd");
		UserDto userDto = new UserDto();
		UserInfoDao userInfoDao = new UserInfoDao();
		userDto.setUserEmailString(userEmail);
		userDto.setUserPasswordString(userPassword);
		HttpSession session =request.getSession();
//		System.out.println(session.isNew()+"---------------");
		if(userInfoDao.isUser(userDto)){
			System.out.println("登录成功");
			session.setAttribute("login", userEmail);
			session.setAttribute("userName", userInfoDao.getUserByEmail(userEmail).getUserNameString());
			session.setAttribute("user", userInfoDao.getUserByEmail(userEmail));
			request.setAttribute("loginOk", "true");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else{
			  long time=  System.currentTimeMillis();
			  int i=1;
			  System.out.println(time);
			  System.out.println((System.currentTimeMillis()-time)/1000);
			  response.getWriter().println("<!DOCTYPE html>"+"<center><strong>您用户名或者密码错误，请返回重试</strong><br/><a href='javascript:window.history.go(-1)'>返回</a></center>");
//			  while(i==1){
//				  long now=System.currentTimeMillis();
//				 
//				  if((now-time)/1000>2){
//					  i=2;
//				  }
//				  
//				  
//			  }
			  return;
			
			//request.getRequestDispatcher("//login.html").forward(request, response);
		}

	}

}
