package edu.csu.speedo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author tangbutian
 *
 */
public class CollarStyleDao extends BaseDao {


	//通过id获取name
	public String getCollarStyleNameById(int collarStyleId) {
		String collarStyleName = null;
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "select [collar_style] from [Collar] where [collar_id] = ?";

		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1, collarStyleId);
			resultSet = prst.executeQuery();
			if (resultSet.next())
				collarStyleName = resultSet.getString(1);
			// 关闭结果集
			resultSet.close();
			// 释放connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return collarStyleName;
	}
	//通过Name获取id
	public int getCollarStyleIdByName(String collarStyleName) {
		int collarStyleId = -1;
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "select [collar_id] from [Collar] where [collar_style] = ?";

		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setString(1, collarStyleName);
			resultSet = prst.executeQuery();
			if (resultSet.next())
				collarStyleId = resultSet.getInt(1);
			// 关闭结果集
			resultSet.close();
			// 释放connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return collarStyleId;
	}
	//添加新样式
	public int addCollarStyle(int collarStyleId, String collarStyleName){
		
		int result = -1;
		PreparedStatement prst = null;
		String sqlString = "insert into [Collar] values(?,?)";
		try {
			prst = super.connection.prepareStatement(sqlString);
			//prst.setInt(1, collarStyleId);
			prst.setString(2, collarStyleName);
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
