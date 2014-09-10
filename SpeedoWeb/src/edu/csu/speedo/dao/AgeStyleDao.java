package edu.csu.speedo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author tangbutian
 *
 */
public class AgeStyleDao extends BaseDao {

	//通过id获取name
	public String getAgeStyleNameById(int ageStyleId) {
		String ageStyleName = null;
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "select [age_style] from [Age] where [age_id] = ?";

		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1, ageStyleId);
			resultSet = prst.executeQuery();
			if (resultSet.next())
				ageStyleName = resultSet.getString(1);
			// 关闭结果集
			resultSet.close();
			// 释放connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ageStyleName;
	}
	//通过Name获取id
	public int getAgeStyleIdByName(String ageStyleName) {
		int ageStyleId = -1;
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "select [age_id] from [Age] where [age_style] = ?";

		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setString(1, ageStyleName);
			resultSet = prst.executeQuery();
			if (resultSet.next())
				ageStyleId = resultSet.getInt(1);
			// 关闭结果集
			resultSet.close();
			// 释放connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ageStyleId;
	}
	//添加新样式
	public int addAgeStyle(int ageStyleId, String ageStyleName){
		
		int result = -1;
		PreparedStatement prst = null;
		String sqlString = "insert into [Age] values(?,?)";
		try {
			prst = super.connection.prepareStatement(sqlString);
			//prst.setInt(1, ageStyleId);
			//已经设置id为标识列，不需要insert
			prst.setString(2, ageStyleName);
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
