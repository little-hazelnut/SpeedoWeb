package edu.csu.speedo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author tangbutian
 *
 */
public class SizeDao extends BaseDao{

	//通过id获取name
	public String getsizeStyleNameById(int sizeId) {
		String sizeStyleName = null;
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "select [size_style] from [Size] where [size_id] = ?";

		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1, sizeId);
			resultSet = prst.executeQuery();
			if (resultSet.next())
				sizeStyleName = resultSet.getString(1);
			// 关闭结果集
			resultSet.close();
			// 释放connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sizeStyleName;
	}
	//通过Name获取id
	public int getsizeIdByName(String sizeStyleName) {
		int sizeId = -1;
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "select [size_id] from [Size] where [size_style] = ?";

		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setString(1, sizeStyleName);
			resultSet = prst.executeQuery();
			if (resultSet.next())
				sizeId = resultSet.getInt(1);
			// 关闭结果集
			resultSet.close();
			// 释放connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sizeId;
	}
	//添加新号码
	public int addsize(int sizeId, String sizeStyleName){
		
		int result = -1;
		PreparedStatement prst = null;
		String sqlString = "insert into [Size] values(?,?)";
		try {
			prst = super.connection.prepareStatement(sqlString);
			//prst.setInt(1, sizeId);
			prst.setString(2, sizeStyleName);
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
