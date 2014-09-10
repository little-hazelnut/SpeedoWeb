package edu.csu.speedo.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csu.speedo.dao.PictureCommentDao;
import edu.csu.speedo.dao.PictureDao;
import edu.csu.speedo.dao.PictureHasStyleDao;
import edu.csu.speedo.dao.TagStyle;
import edu.csu.speedo.dao.UserInfoDao;
import edu.csu.speedo.dbutil.SimpleConnetionPool;
import edu.csu.speedo.dto.PictureCommentDto;
import edu.csu.speedo.dto.PictureDto;
import edu.csu.speedo.dto.UserDto;

public class ShowItem extends HttpServlet {

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

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");// 得到商品id
		System.out.println("inner ShowItem:"+id);
		int picid = Integer.parseInt(id);
		// 取出数据库数据
		PictureCommentDao comment = new PictureCommentDao();
		ArrayList<PictureCommentDto> piccom = comment
				.getPictureCommentDtoById(picid);// 图片评论

		PictureDao pic = new PictureDao();
		PictureDto picdto = pic.getPictureById(picid);// 图片信息

		PictureHasStyleDao pstyle = new PictureHasStyleDao();
		ArrayList<Integer> styleId = pstyle.gettagId(picid);// 获得tagid信息
		ArrayList<String> tag = new ArrayList();
		TagStyle tags = new TagStyle();
		for (int i = 0; i < styleId.size(); i++) {
			String style = tags.getTagNameById(styleId.get(i));
			tag.add(style);
		}// 所有标签信息存入了tag数组

		UserInfoDao uinfo = new UserInfoDao();
		UserDto udto = uinfo.getUserById(picdto.getUserId());
		// 将数据存入request
		request.setAttribute("piccom", piccom);
		System.out.println(piccom);
		request.setAttribute("picdto", picdto);
		System.out.println(picdto);
		request.setAttribute("tag", tag);
		System.out.println(tag);
		request.setAttribute("uinfo", uinfo);
		System.out.println(uinfo);
		// 转发request

		//String path = request.getContextPath();
		//String basePath = request.getScheme() + "://" + request.getServerName()
		//		+ ":" + request.getServerPort() + path + "/";

		request.getRequestDispatcher("/blog-entry.jsp").forward(request,
				response);
	}
}
