package edu.csu.speedo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import edu.csu.speedo.dto.ProductDto;

/**
 * @author tangbutian
 *
 */
public class ProductDao extends BaseDao {

	//通过ProductId返回ProductDto
	public ProductDto getProductById(int productId){
		ProductDto pd = new ProductDto();
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "SELECT * FROM [Product] WHERE [product_id]=?";
		try{
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1,productId);
			resultSet = prst.executeQuery();
			while(resultSet.next()) {
				pd.setProductId(productId);
				pd.setProductPrice(resultSet.getInt("product_price"));
				pd.setProductAccount(resultSet.getInt("product_account"));
				pd.setProductAmount(resultSet.getInt("product_amount"));
				pd.setProductColor(new ColorDao().getcolorNameById(resultSet.getInt("product_color")));
				pd.setProductSize(new SizeDao().getsizeStyleNameById(resultSet.getInt("product_size")));
				pd.setProductCollar(new CollarStyleDao().getCollarStyleNameById(resultSet.getInt("product_collar")));
				pd.setProductPictureId(resultSet.getInt("product_picture_id"));
				pd.setProductAge(new AgeStyleDao().getAgeStyleNameById(resultSet.getInt("product_age")));
				pd.setImgSrc(new PictureDao().getImgSrcById(resultSet.getInt("product_picture_id")));
			
				pd.setProductName(resultSet.getString("product_name"));
			}
			// 关闭结果集
			resultSet.close();
			// 释放connection
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return pd;
	}
	//返回按页面amount和分页index的ArrayList<>
	/*
	 * int amount页面大小
	 * int index页数
	 * 分页SQL
	 * SELECT TOP 页大小 * 
	 * FROM 
	 * (
	 *  SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM table1
	 * ) A
	 * WHERE RowNumber > 页大小*(页数-1) 
	 * 
	 * */
	public ArrayList<ProductDto> getAllProduct(int index, int amount){
		ArrayList<ProductDto> arrayListProductDtos = new ArrayList<ProductDto>();
		PreparedStatement prst = null;
		ResultSet resultSet = null;

		//String sqlString = "SELECT TOP 10 * FROM ( SELECT ROW_NUMBER() OVER (ORDER BY [product_id]) AS RowNumber,* FROM [Product] ) A WHERE RowNumber > 10 * ( 2 - 1)";

		String sqlString = "SELECT TOP 16 * FROM ( SELECT ROW_NUMBER() OVER (ORDER BY [product_id]) AS RowNumber,* FROM [Product] ) A WHERE RowNumber > ? * ( ? - 1)";

		try {
			prst = super.connection.prepareStatement(sqlString);
			//prst.setInt(1, 10);


			//prst.setInt(1, 10);
			System.out.println(index);
		

			prst.setInt(1,16);
			prst.setInt(2, index);

			resultSet = prst.executeQuery();

			System.out.print("ok");

			while(resultSet.next()){
				ProductDto productDto = new ProductDto();
				
				productDto.setProductId(resultSet.getInt("product_id"));

				System.out.print(resultSet.getInt("product_id"));

				productDto.setProductPrice(resultSet.getInt("product_price"));
				productDto.setProductAccount(resultSet.getInt("product_account"));
				productDto.setProductAmount(resultSet.getInt("product_amount"));
				productDto.setProductColor(new ColorDao().getcolorNameById(resultSet.getInt("product_color")));
				productDto.setProductCollar(new CollarStyleDao().getCollarStyleNameById(resultSet.getInt("product_collar")));
				productDto.setProductSize(new SizeDao().getsizeStyleNameById(resultSet.getInt("product_size")));
				productDto.setProductAge(new AgeStyleDao().getAgeStyleNameById(resultSet.getInt("product_age")));
				productDto.setProductPictureId(resultSet.getInt("product_picture_id"));
				productDto.setImgSrc(new PictureDao().getImgSrcById(resultSet.getInt("product_picture_id")));
				productDto.setProductName(resultSet.getString("product_name"));
				arrayListProductDtos.add(productDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arrayListProductDtos;
	}
}
