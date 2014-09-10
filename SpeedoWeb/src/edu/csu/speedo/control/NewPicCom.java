package edu.csu.speedo.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csu.speedo.dao.PictureCommentDao;
import edu.csu.speedo.dto.PictureCommentDto;

public class NewPicCom extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public NewPicCom() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
             int userId=Integer.parseInt(request.getParameter("userId"));
             int picId=Integer.parseInt(request.getParameter("picId"));
             String commentContent=request.getParameter("com");
             int comS=Integer.parseInt(request.getParameter("comS"));
           
             System.out.println(userId);
             System.out.println(comS);
             System.out.println(commentContent);
             System.out.println(picId);

             PictureCommentDto pcd=new PictureCommentDto();
             pcd.setCommentContent(commentContent);
             pcd.setPictureId(picId);
             pcd.setCommentScore(comS);
             pcd.setUserId(userId);
             pcd.setCommentDate(new Date(System.currentTimeMillis()));
             PictureCommentDao pc=new PictureCommentDao();
             pc.addNewPictureComment(pcd);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
