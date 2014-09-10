package edu.csu.speedo.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csu.speedo.dao.PictureCommentDao;
import edu.csu.speedo.dao.PictureDao;
import edu.csu.speedo.dao.ProductCommentDao;
import edu.csu.speedo.dao.UserInfoDao;
import edu.csu.speedo.dto.PictureDto;
import edu.csu.speedo.dto.ProductCommentDto;
import edu.csu.speedo.dto.UserDto;
import edu.csu.speedo.pojo.PicCom;

public class ListPicture extends HttpServlet {

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
		//amount是每个页面的数量  index是当前页数
		//.......int productId = (Integer) request.getSession().getAttribute("productId");
		//通过ProductId获得所有的评论信息
//		ArrayList<ProductCommentDto> arrayListProductCommentDtos = new ProductCommentDao().getProductCommentDtoByProductId(productId);
//		Iterator<ProductCommentDto> iterator = arrayListProductCommentDtos.iterator();
//		while(iterator.hasNext()){
//			totalScore += iterator.next().getProductCommentScore();
//			System.out.println(totalScore);
//		}
//		//计算平均分
//		int avgScore = totalScore / arrayListProductCommentDtos.size();
//		//把平均分写入session
//		request.getSession().setAttribute("avgScore", avgScore);
		int index;
		
		ArrayList<Integer> scr=new ArrayList<Integer>();
		if(request.getParameter("index")==null)index=1;
		else{
		 index = Integer.parseInt(request.getParameter("index"));}
		ArrayList<PictureDto> pictureList = new ArrayList<PictureDto>();
		ArrayList<PicCom> pic1=new ArrayList<PicCom>();
		PictureDao pd = new PictureDao();
		pictureList = pd.getAllPictureDtos(16, index);
		PictureCommentDao pcd=new PictureCommentDao();
		for(int i=0;i<pictureList.size();i++){
			int pictureId = pictureList.get(i).getPictureId();
			int score =pcd.getPASById(pictureId);
			PicCom picCom=new PicCom();
			picCom.setScore(score);
			picCom.setPic(pictureList.get(i));
			pic1.add(picCom);
			System.out.println(score);
			
		}
		request.setAttribute("id", index);
		//System.out.println(request.getAttribute("id")+"rrrr");
		request.setAttribute("pic", pic1);
		request.getRequestDispatcher("/blog.jsp").forward(request, response);

	}

}
