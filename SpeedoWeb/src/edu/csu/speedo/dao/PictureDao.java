package edu.csu.speedo.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.csu.speedo.dto.PictureDto;

/**
 * @author tangbutian
 *
 */
public class PictureDao extends BaseDao {
	//获得评分前firstNumOfScore的Picture的ArrayList集合
	public ArrayList<PictureDto> getFirstNumOfScoreArrayListOfPictureDtos(int firstNumOfScore){
		ArrayList<PictureDto> arrayListPictureDtos = new ArrayList<PictureDto>();
		
		
		return arrayListPictureDtos;
	}

	//获得最新上传的firstNumOfDate的Picture的ArrayList集合
	public ArrayList<PictureDto> getFirstNumOfDateArrayListOfPictureDtos(int firstNumOfDate){
		ArrayList<PictureDto> arrayListPictureDtos = new ArrayList<PictureDto>();
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlsString = "SELECT TOP ? * FROM [Picture] ORDER BY [upload_date] DESC ";
		try {
			prst = super.connection.prepareStatement(sqlsString);
			prst.setInt(1, firstNumOfDate);
			resultSet = prst.executeQuery();
			while(resultSet.next()){
				PictureDto pictureDto = new PictureDto();
				pictureDto.setUserId(resultSet.getInt("user_id"));
				pictureDto.setDescription(resultSet.getString("description"));
				pictureDto.setImgSrc(resultSet.getString("image"));
				pictureDto.setPictureId(resultSet.getInt("picture_id"));
				pictureDto.setUploadDate(resultSet.getDate("upload_date"));
				pictureDto.setPictureName(resultSet.getString("picture_name"));
			
				arrayListPictureDtos.add(pictureDto);
			}
			// 关闭结果集
			resultSet.close();
			// 释放connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return arrayListPictureDtos;
	}

	//通过picture的Id获取picture的upload_time
	public Date getUploadDateById(int pictureId){
		Date date = null;
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "select [upload_date] from [Picture] where [picture_id] = ?";
		
		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1, pictureId);
			resultSet = prst.executeQuery();
			if (resultSet.next())
				date = resultSet.getDate(1);
			// 关闭结果集
			resultSet.close();
			// 释放connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	//通过picture的Id获取picture的description
	public String getDescriptionById(int pictureId){
		String description = null;
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "select [description] from [Picture] where [picture_id] = ?";

		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1, pictureId);
			resultSet = prst.executeQuery();
			if (resultSet.next())
				description = resultSet.getString(1);
			// 关闭结果集
			resultSet.close();
			// 释放connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return description;
	}
	
	//通过picture的Id获取picture的imgSrc
	public String getImgSrcById(int pictureId){
		String image = null;
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "select [image] from [Picture] where [picture_id] = ?";

		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1, pictureId);
			resultSet = prst.executeQuery();
			if (resultSet.next())
				image = resultSet.getString(1);
			// 关闭结果集
			resultSet.close();
			// 释放connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;		
	}
	
	//通过picture的Id获取picture的user_id
	public int getUserIdbyId(int pictureId){
		int userId = 0;
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "select [user_id] from [Picture] where [picture_id] = ?";

		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1, pictureId);
			resultSet = prst.executeQuery();
			if (resultSet.next())
				userId = resultSet.getInt(1);
			// 关闭结果集
			resultSet.close();
			// 释放connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userId;
	}
	
	//通过pictureId获取PictureDto对象
	public PictureDto getPictureById(int pictureId){
		PictureDto pd = new PictureDto();
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "select * from [Picture] where [picture_id] = ?";
		try{
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1,pictureId);
			resultSet = prst.executeQuery();
			while(resultSet.next()) {
				pd.setPictureId(pictureId);
				pd.setUploadDate(resultSet.getDate("upload_date"));
				pd.setDescription(resultSet.getString("description"));
				pd.setImgSrc(resultSet.getString("image"));
				pd.setUserId(resultSet.getInt("user_id"));
				pd.setPictureName(resultSet.getString("picture_name"));
				pd.setUserName(new UserInfoDao().getUserById(resultSet.getInt("user_id")).getUserNameString());
				System.out.println(new UserInfoDao().getUserById(resultSet.getInt("user_id")).getUserNameString());
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

	//通过用户Id获取该用户所有的上传图片
	public ArrayList<PictureDto> getPictureByUserId(int userId){
		ArrayList<PictureDto> array = new ArrayList<PictureDto>();
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "select * from [Picture] where [user_id] = ?";
		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1, userId);
			resultSet = prst.executeQuery();
			PictureDto pd = new PictureDto();
			while(resultSet.next()) {
				pd.setPictureId(resultSet.getInt("picture_id"));
				pd.setUploadDate(resultSet.getDate("upload_date"));
				pd.setDescription(resultSet.getString("description"));
				pd.setImgSrc(resultSet.getString("image"));
				pd.setPictureName(resultSet.getString("picture_name"));
				pd.setUserId(userId);
				array.add(pd);
			}
			// 关闭结果集
			resultSet.close();
			// 释放connection
			connection.close();
		} catch(SQLException e){
			e.printStackTrace();
		} 
		
		return array;
	}
	
	//添加新的picture
	public int addNewPicture(PictureDto pictureDto){
		int result = -1;
		PreparedStatement prst = null;
		String sqlString = "insert into [Picture] values(?,?,?,?,?)";
		try {
			prst = super.connection.prepareStatement(sqlString);
			//prst.setInt(1, pictureDto.getPictureId());
			prst.setDate(1, pictureDto.getUploadDate());
			prst.setString(2, pictureDto.getDescription());
			prst.setString(3, pictureDto.getImgSrc());
			prst.setInt(4, pictureDto.getUserId());
			prst.setString(5, pictureDto.getPictureName());
			
			result = prst.executeUpdate();
			//关闭connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//查询所有的picture按分页属性返回
		public ArrayList<PictureDto> getAllPictureDtos(int amount, int index){
			ArrayList<PictureDto> arrayListPictureDtos = new ArrayList<PictureDto>();
			PreparedStatement prst = null;
			ResultSet resultSet = null;
			String sqlString = "SELECT TOP 16 * FROM ( SELECT ROW_NUMBER() OVER (ORDER BY [picture_id]) AS RowNumber,* FROM [Picture] ) A WHERE RowNumber > ?* ( ? - 1)";
			try {
				prst = super.connection.prepareStatement(sqlString);
				prst.setInt(1, amount);
				
				prst.setInt(2, index);
				resultSet = prst.executeQuery();
				while(resultSet.next()){
					PictureDto pd = new PictureDto();
					pd.setPictureId(resultSet.getInt("picture_id"));
					pd.setUploadDate(resultSet.getDate("upload_date")); 
					pd.setDescription(resultSet.getString("description"));
					pd.setImgSrc(resultSet.getString("image"));
					pd.setUserId(resultSet.getInt("user_id"));
					pd.setPictureName(resultSet.getString("picture_name"));
					pd.setUserName(new UserInfoDao().getUserById(resultSet.getInt("user_id")).getUserNameString());
					arrayListPictureDtos.add(pd);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return arrayListPictureDtos;
		}
}
