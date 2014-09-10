package edu.csu.speedo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author tangbutian
 *
 */
public class ColorDao extends BaseDao{
	//通过id获取颜色
	public String getcolorNameById(int colorId) {
		String colorName = null;
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "select [color_style] from [Color] where [color_id] = ?";

		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1, colorId);
			resultSet = prst.executeQuery();
			if (resultSet.next())
				colorName = resultSet.getString(1);
			// 关闭结果集
			resultSet.close();
			// 释放connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return colorName;
	}
	
	//通过Name获取id
	public int getcolorIdByName(String colorName) {
		int colorId = -1;
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "select [color_id] from [Color] where [color_style] = ?";

		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setString(1, colorName);
			resultSet = prst.executeQuery();
			if (resultSet.next())
				colorId = resultSet.getInt(1);
			// 关闭结果集
			resultSet.close();
			// 释放connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return colorId;
	}
	
	//添加新颜色样式
		public int addColorStyle(int colorId, String colorStyleName){
			
			int result = -1;
			PreparedStatement prst = null;
			String sqlString = "insert into [Color] values(?,?)";
			try {
				prst = super.connection.prepareStatement(sqlString);
				//prst.setInt(1, colorId);
				prst.setString(2, colorStyleName);
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
