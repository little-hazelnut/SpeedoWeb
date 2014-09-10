package edu.csu.speedo.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csu.speedo.dao.ProductCommentDao;
import edu.csu.speedo.dto.ProductCommentDto;

public class AvgCommentOfPicture extends HttpServlet {

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
		//定义totalCommentScore变量
		int totalScore = 0;
		//通过request获取ProductId
		int productId = (Integer) request.getSession().getAttribute("productId");
		//通过ProductId获得所有的评论信息
		ArrayList<ProductCommentDto> arrayListProductCommentDtos = new ProductCommentDao().getProductCommentDtoByProductId(productId);
		Iterator<ProductCommentDto> iterator = arrayListProductCommentDtos.iterator();
		while(iterator.hasNext()){
			totalScore += iterator.next().getProductCommentScore();
			System.out.println(totalScore);
		}
		//计算平均分
		int avgScore = totalScore / arrayListProductCommentDtos.size();
		//把平均分写入session
		request.getSession().setAttribute("avgScore", avgScore);
		
	}

}
