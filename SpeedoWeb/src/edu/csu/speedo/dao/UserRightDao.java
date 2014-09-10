package edu.csu.speedo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//用户权限表的数据访问对象
public class UserRightDao extends BaseDao {

	//通过用户权限id获取用户权限name
	public String getUserRightNameById(int userRightId){
		String userRightString = null;
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "SELECT userright_name from [userRight] where userright_id = ?";
		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1, userRightId);
			resultSet = prst.executeQuery();
			if(resultSet.next())
				userRightString = resultSet.getString("userright_name");
			resultSet.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userRightString;
		
	}
	//通过用户权限name获取用户权限id
	public int getUserRightIdByName(String userName){
		int userRightId = 0;
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "SELECT userright_id from [userRight] where userright_name = ?";
		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setString(1, userName);
			resultSet = prst.executeQuery();
			if(resultSet.next())
				userRightId = resultSet.getInt("userright_id");
			resultSet.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userRightId;
		
	}
}
