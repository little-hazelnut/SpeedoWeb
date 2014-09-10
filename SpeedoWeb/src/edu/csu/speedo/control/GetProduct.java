package edu.csu.speedo.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csu.speedo.dao.OrderInfoDao;
import edu.csu.speedo.dao.ProductDao;
import edu.csu.speedo.dto.OrderInfoDto;
import edu.csu.speedo.dto.ProductDto;
import edu.csu.speedo.pojo.CarItem;

public class GetProduct extends HttpServlet {

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
		
		//定义ArrayListProductDto
		ArrayList<CarItem> arrayListProductDtos = new ArrayList<CarItem>();
		// 从session中获取购物车信息
		if(request.getSession().getAttribute("goods")!=null){
		HashMap<String, Integer> thing = (HashMap<String, Integer>) request.getSession().getAttribute("goods");
		System.out.println(thing.size());
		//计算totalVal
		int totalVal = 0;
		// 遍历hashMap,构造orderInfoDto存入数据库,计算总结
		Iterator iter = thing.entrySet().iterator();
		while (iter.hasNext()) {
			ProductDto productDto = new ProductDto();
			CarItem carItem = new CarItem();
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			
			Object val = entry.getValue();
			//通过productId获取ProductDto
			productDto = new ProductDao().getProductById(Integer.parseInt(key.toString()));
			carItem.setProductDto(productDto);
			carItem.setValue(Integer.parseInt(val.toString()));
			totalVal += Integer.parseInt(val.toString()) * productDto.getProductPrice();
			arrayListProductDtos.add(carItem);
		}
		
		request.getSession().setAttribute("products", arrayListProductDtos);
		request.getSession().setAttribute("totalVal", totalVal);}
if(request.getParameter("a")==null)
{System.out.println(1);
		request.getRequestDispatcher("/cart.jsp").forward(request,response);}
else{request.getRequestDispatcher("/orderApply.jsp").forward(request,response);}
		
//System.out.println(totalVal);
	}

}
