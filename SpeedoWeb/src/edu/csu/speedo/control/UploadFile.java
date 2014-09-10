package edu.csu.speedo.control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadFile extends HttpServlet {

	private String uploadPath = "c:\\temp"; // 上传文件的目录

	private String tempPath = "c:\\temp\\buffer\\"; // 临时文件目录

	File tempPathFile;
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
		
		int UUID = (int) (System.currentTimeMillis() / 1000);

		try {

			// Create a factory for disk-based file items

			DiskFileItemFactory factory = new DiskFileItemFactory();

			// Set factory constraints

			factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb

			factory.setRepository(tempPathFile);// 设置缓冲区目录

			// Create a new file upload handler

			ServletFileUpload upload = new ServletFileUpload(factory);

			// Set overall request size constraint

			upload.setSizeMax(4194304); // 设置最大文件尺寸，这里是4MB

			List<FileItem> items = upload.parseRequest(request);// 得到所有的文件

			Iterator<FileItem> i = items.iterator();

			while (i.hasNext()) {

				FileItem fi = (FileItem) i.next();

				String fileName = fi.getName();
				
				if (fi.isFormField()) {

					String content = fi.getString("UTF-8"); 

					String fieldName = fi.getFieldName(); 

					request.setAttribute(fieldName,content); 
					
				}

				if (fileName != null) {
					//能正常显示
					fileName = UUID+fileName.substring(fileName.lastIndexOf("."));
					//不能正常显示中文
					//fileName = UUID+fileName;
					System.out.println(fileName);
					File fullFile = new File(fileName);
					//绝对路径用来上传写文件
					String address = request.getSession().getServletContext().getRealPath("/UserIcon")+ "/"  + fileName;
					System.out.println(address);
					//相对路径用来写入数据库
					String relatedAddress = "./UserIcon"+ "/" + fileName;
					System.out.println(relatedAddress);

					request.setAttribute("url", relatedAddress);
					request.setAttribute("pictureId", UUID);
					File savedFile = new File(address);
					

					fi.write(savedFile);


				}

			}

			System.out.print("upload succeed");

		} catch (Exception e) {

			// 可以跳转出错页面

			e.printStackTrace();

		}
		
		request.getRequestDispatcher("/servlet/ControlDIY").forward(request, response);
	}

	public void init() throws ServletException {

		File uploadFile = new File(uploadPath);

		if (!uploadFile.exists()) {

			uploadFile.mkdirs();

		}

		File tempPathFile = new File(tempPath);

		if (!tempPathFile.exists()) {

			tempPathFile.mkdirs();

		}

	}

}
