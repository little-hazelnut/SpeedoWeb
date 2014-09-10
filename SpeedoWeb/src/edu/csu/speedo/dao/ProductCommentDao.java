package edu.csu.speedo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import edu.csu.speedo.dto.ProductCommentDto;

/**
 * @author tangbutian
 *
 */
public class ProductCommentDao extends BaseDao {
	//通过ProductID返回所有该product下的所有ProductComment
    public ArrayList<ProductCommentDto> getProductCommentDtoByProductId(int productId)
    {
    	ArrayList<ProductCommentDto> arryProductComment= new ArrayList<ProductCommentDto>();
    	PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "select * from [Product_comment] where [product_id] = ?";
		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1, productId);
			resultSet = prst.executeQuery();
			while (resultSet.next()) {
				ProductCommentDto oid = new ProductCommentDto();
				oid.setProductCommentId(resultSet.getInt("productcomment_id"));
				oid.setProductId(productId);
				oid.setProductCommentScore(resultSet.getInt("productcomment_score"));
				oid.setProductCommentDescription(resultSet.getString("productcomment_description"));
				oid.setProductCommentUserId(resultSet.getInt("user_id"));
				arryProductComment.add(oid);
			}
			// 关闭结果集
			resultSet.close();
			// 释放connection
			connection.close();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	return arryProductComment;
    	
    }
    //添加新的评论
    public int  AddNewProductComment(ProductCommentDto productCommentDto)
    {
    	int result = -1;
		PreparedStatement prst = null;
		String sqlString = "insert into [Product_comment] values(?,?,?,?)";
		try {
			prst = super.connection.prepareStatement(sqlString);
			//prst.setInt(1, productCommentDto.getProductCommentId());
			prst.setInt(1, productCommentDto.getProductId());
			prst.setInt(2, productCommentDto.getProductCommentScore());
			prst.setString(3, productCommentDto.getProductCommentDescription());
			prst.setInt(4, productCommentDto.getProductCommentUserId());
			result = prst.executeUpdate();
			//关闭connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
    	
    }
}
