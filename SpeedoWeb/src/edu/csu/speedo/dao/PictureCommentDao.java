package edu.csu.speedo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.csu.speedo.dto.PictureCommentDto;
import edu.csu.speedo.dto.PictureDto;

/**
 * @author tangbutian
 *
 */
public class PictureCommentDao extends BaseDao{

	//返回同一PictureId之下的所有评论对象
	public ArrayList<PictureCommentDto> getPictureCommentDtoById(int pictureId){
		ArrayList<PictureCommentDto> arrayPC = new ArrayList<PictureCommentDto>();
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "select * from [Picture_comment] where [picture_id] = ?";
		try{
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1, pictureId);
			resultSet = prst.executeQuery();
			while(resultSet.next()) {
				PictureCommentDto pcd = new PictureCommentDto();
				pcd.setCommentId(resultSet.getInt("comment_id"));
				pcd.setUserId(resultSet.getInt("user_id"));
				pcd.setPictureId(pictureId);
				pcd.setCommentDate(resultSet.getDate("comment_date"));
				pcd.setCommentContent(resultSet.getString("comment_content"));
				pcd.setCommentScore(resultSet.getInt("comment_score"));
				arrayPC.add(pcd);
			}		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return arrayPC;
	}
	
	
	//Add新的评论
	public int addNewPictureComment(PictureCommentDto pictureCommentDto){
		int result = -1;
		PreparedStatement prst = null;
		String sqlString = "insert into [Picture_comment] values(?,?,?,?,?)";
		try {
			prst = super.connection.prepareStatement(sqlString);
			//prst.setInt(1, pictureCommentDto.getCommentId());
			prst.setInt(1, pictureCommentDto.getUserId());
			prst.setInt(2, pictureCommentDto.getPictureId());
			prst.setDate(3, pictureCommentDto.getCommentDate());
			prst.setString(4, pictureCommentDto.getCommentContent());
			prst.setInt(5, pictureCommentDto.getCommentScore());
			result = prst.executeUpdate();
			//关闭connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public int getPASById(int pictureId){
		ArrayList<PictureCommentDto> arrayPC = new ArrayList<PictureCommentDto>();
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		int a=0;
		String sqlString = "select AVG(comment_score) as comment_score from [Picture_comment] where [picture_id] = ?";
		try{
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1, pictureId);
			resultSet = prst.executeQuery();
			while(resultSet.next()) {
				 a= resultSet.getInt("comment_score");
			}		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
}
