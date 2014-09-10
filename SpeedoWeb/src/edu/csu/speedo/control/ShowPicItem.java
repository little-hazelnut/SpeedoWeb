package edu.csu.speedo.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csu.speedo.dao.PictureDao;
import edu.csu.speedo.dto.PictureDto;

public class ShowPicItem extends HttpServlet {

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
		//request获取pictureId
		int pictureId = Integer.parseInt(request.getParameter("id").toString());
		//获取PictureDto
		PictureDto pictureDto = new PictureDao().getPictureById(pictureId);
		//放入request
		request.setAttribute("picture", pictureDto);
		System.out.println(pictureDto.getUserName());
		request.getRequestDispatcher("/designer-work.jsp").forward(request, response);
		
	}

}
