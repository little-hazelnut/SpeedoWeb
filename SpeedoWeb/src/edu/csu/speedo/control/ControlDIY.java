package edu.csu.speedo.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csu.speedo.dao.PictureDao;
import edu.csu.speedo.dao.UserInfoDao;
import edu.csu.speedo.dto.PictureDto;
import edu.csu.speedo.dto.UserDto;

public class ControlDIY extends HttpServlet {

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
		// 从session中获取用户信息
		 UserDto userDto = (UserDto)request.getSession().getAttribute("user");
		 int userId = userDto.getUserId();
		 System.out.println(userDto.getUserNameString());
		// 从request中获取页面提交的picture信息
		int pictureId = (Integer) request.getAttribute("pictureId");
		String imgSrc = (String) request.getAttribute("url");
		String pictureDescription = (String) request
				.getAttribute("designs_about");
		String pictureName = (String) request.getAttribute("worktitle");
		Date uploadDate = new Date(System.currentTimeMillis());
		// 构造PictureDto
		PictureDto pictureDto = new PictureDto();
		pictureDto.setUserId(userId);// 临时写入用户Id为1
		pictureDto.setUploadDate(uploadDate);
		pictureDto.setImgSrc(imgSrc);
		pictureDto.setPictureId(pictureId);
		pictureDto.setDescription(pictureDescription);
		pictureDto.setPictureName(pictureName);
		// 向数据库写入数据
		if (new PictureDao().addNewPicture(pictureDto) == 1) {
			System.out.println("添加picture成功");
//			response.setContentType("text/html");
//			PrintWriter out = response.getWriter();
//			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//			out.println("<HTML>");
//			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//			out.println("  <BODY>");
//
//			out.println("图片添加成功");
//			out.println("  </BODY>");
//			out.println("</HTML>");
//			out.flush();
//			out.close();
			request.setAttribute("upload", "true");
			request.getRequestDispatcher("/diy-work.jsp").forward(request, response);
		} else {
//			response.setContentType("text/html");
//			PrintWriter out = response.getWriter();
//			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//			out.println("<HTML>");
//			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//			out.println("  <BODY>");
//
//			out.println("图片添加失败");
//			out.println("  </BODY>");
//			out.println("</HTML>");
//			out.flush();
//			out.close();
			request.setAttribute("upload", "false");
			request.getRequestDispatcher("/diy-work.jsp").forward(request, response);
		}

	}

}
