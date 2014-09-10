package edu.csu.speedo.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csu.speedo.dao.PictureDao;
import edu.csu.speedo.dao.ProductDao;
import edu.csu.speedo.dto.PictureDto;
import edu.csu.speedo.dto.ProductDto;

public class ListProduct extends HttpServlet {

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
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
response.setContentType("text/html");

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
		//int amount = Integer.parseInt(request.getParameter("amount"));
		int index;
		if(request.getParameter("index")==null)index=1;
		
		else{
		 index = Integer.parseInt(request.getParameter("index"));
		 System.out.println(index+"t");}
	
		//System.out.print(index);
		//if (index==null)index=1;
		ArrayList<ProductDto> productList = new ArrayList<ProductDto>();
		ProductDao pd = new ProductDao();
		productList = pd.getAllProduct(index, 20);
		System.out.println(productList.size());
		if(productList==null||productList.size()==0){
			response.getWriter().println("<!DOCTYPE html>"+"<center><strong>您访问的页面不存在，请返回重试</strong><br/><a href='javascript:window.history.go(-1)'>返回</a></center>");
			return;
		}
		else{		request.setAttribute("id", index);
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("/shop.jsp").forward(request, response);}

	}
}
