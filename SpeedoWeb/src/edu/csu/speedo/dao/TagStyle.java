package edu.csu.speedo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TagStyle extends BaseDao {
	// 通过id获取颜色
	public String getTagNameById(int tagId) {
		String tagName = null;
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "select [tag_style] from [TagStyle] where [tag_id] = ?";

		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1, tagId);
			resultSet = prst.executeQuery();
			if (resultSet.next())
				tagName = resultSet.getString(1);
			// 关闭结果集
			resultSet.close();
			// 释放connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tagName;
	}

	// 通过Name获取id
	public int getTagIdByName(String tagName) {
		int tagId = -1;
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "select [tag_id] from [TagStyle] where [tag_name] = ?";

		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setString(1, tagName);
			resultSet = prst.executeQuery();
			if (resultSet.next())
				tagId = resultSet.getInt(1);
			// 关闭结果集
			resultSet.close();
			// 释放connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tagId;
	}

}
