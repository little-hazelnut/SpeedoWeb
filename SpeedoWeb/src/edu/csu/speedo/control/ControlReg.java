package edu.csu.speedo.control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csu.speedo.dao.UserInfoDao;
import edu.csu.speedo.dto.UserDto;


import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

public class ControlReg extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("inner controlReg");
		int userId = (int) (System.currentTimeMillis() / 1000);
		System.out.println(userId);


		//通过被转发的请求获取相应信息
//		String emailString = (String) request.getAttribute("email");
//		System.out.println("email in request= " +emailString);
//		String userNameString = (String) request.getAttribute("username");
//		System.out.println("name in request= "+userNameString);
//		String userPasswordString = (String) request.getAttribute("password");
//		System.out.println("password in request= "+userPasswordString);
//		String filePathString = (String)request.getAttribute("url");
//		System.out.println(filePathString);
		//通过request中的字段name获取相应注册信息
		String emailString = request.getParameter("rgt-email");
		String userPasswordString = request.getParameter("rgt-pwd");
		
		//通过email截取@之前部分设置默认用户名，可以修改
		String userNameString = emailString.substring(0, emailString.indexOf("@"));
		

		// 设置默认用户权限为普通用户
		String userRightName = "普通用户";

		UserDto userDto = new UserDto();
		userDto.setUserAddress("中南大学");
		userDto.setUserBirthday(new Date(System.currentTimeMillis()));
		userDto.setUserEmailString(emailString);
		//userDto.setUserIconUrlString(filePathString);
		userDto.setUserIconUrlString("./UserIcon/icon.jpg");
		userDto.setUserId(userId);
		userDto.setUserNameString(userNameString);
		userDto.setUserPasswordString(userPasswordString);
		userDto.setUserPhoneNumberString("13000000000");
		userDto.setUserRightString(userRightName);
		userDto.setUserScoreString("888");
		userDto.setUserSex("男");


		UserInfoDao userInfoDao = new UserInfoDao();
		//userInfoDao.addUser(userDto);


		
		String path = request.getContextPath();

		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

		//response.sendRedirect(basePath+"servlet/ListUser");

		if(userInfoDao.addUser(userDto) !=0 )
		{
			request.getSession().setAttribute("user", userDto);
		
			request.getSession().setAttribute("login", emailString);
			request.getSession().setAttribute("userName", userDto.getUserNameString());
			//request.session.setAttribute("user", userInfoDao.getUserByEmail(userEmail));
			request.getRequestDispatcher("/index.jsp").forward(request, response);}
		else {
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}



}
