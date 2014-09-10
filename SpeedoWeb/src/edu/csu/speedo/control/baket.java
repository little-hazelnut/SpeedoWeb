package edu.csu.speedo.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class baket extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public baket() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
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

//	int num=	Integer.parseInt(request.getParameter("num"));
//	String id=request.getParameter("id");
//	System.out.println(id);
//	HttpSession s=request.getSession();
//Item item=new Item(num,id);//新的商品叫item
//
////如果session中没有goods这个商品集合，那么hashmap goods，加入商品
//
//if(s.getAttribute("goods")==null){
//	HashMap<String,Item> thing=new HashMap<String,Item>();
//	thing.put(id,item);
//	s.setAttribute("goods",thing );
//	//System.out.println(1);
//}


		int num = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		HttpSession s = request.getSession();
		Item item = new Item(num, id);// 新的商品叫item

		// 如果session中没有goods这个商品集合，那么hashmap goods，加入商品

		if (s.getAttribute("goods") == null) {
			HashMap<String, Integer> thing = new HashMap<String, Integer>();
			thing.put(id, num);
			s.setAttribute("goods", thing);
		}

		// 如果session中有商品集合，那么修改它
		// 如果商品集合中没有该商品，则添加
		else {
			HashMap<String, Integer> thing = (HashMap<String, Integer>) s.getAttribute("goods");
			if (thing.get(id) == null) {
				thing.put(id, num);
			}
			// 如果商品集合中有该商品，那么修改该商品
			else {
			
				thing.put(id, num);
			}
			s.setAttribute("goods", thing);
		}
		System.out.println(((HashMap)s.getAttribute("goods")).size());

//else{
//	HashMap<String,Item> thing= (HashMap<String, Item>) s.getAttribute("goods");
//	if(thing.get(id)==null){
//		thing.put(id, item);
//	//	System.out.println(2);
//	}
//	//如果商品集合中有该商品，那么修改该商品
//	else{
//		Item new1=thing.get(id);
//		new1.setId(id);new1.setNum(num);
//		thing.put(id, new1);
//		//System.out.println(3);
//	}
//	s.setAttribute("goods", thing);
//}
//	//System.out.println(((HashMap<String, Item>)s.getAttribute("goods")).get("1"));

	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
