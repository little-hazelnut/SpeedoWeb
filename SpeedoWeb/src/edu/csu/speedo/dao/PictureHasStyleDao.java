package edu.csu.speedo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author tangbutian
 *
 */
public class PictureHasStyleDao extends BaseDao{
	public int pictureId;
	public int tagId;
	
	//通过tagid取得所有这个标签下的pictureid集合
	public ArrayList<Integer> getpictureId(int tagId) {
		ArrayList<Integer> arrayPid = new ArrayList<Integer>();
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "select [picture_id] from [PictureHasStyle] where [tag_id] = ?";
	
		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1, tagId);
			resultSet = prst.executeQuery();
			while (resultSet.next()) {
				arrayPid.add(resultSet.getInt(1));
			}
			// 关闭结果集
			resultSet.close();
			// 释放connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayPid;
	}
	
	//通过pictureid取得所有这个图片的相关tagid的集合
	public ArrayList<Integer> gettagId(int pictureId) {
		ArrayList<Integer> arrayTid = new ArrayList<Integer>();
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "select [tag_id] from [PictureHasStyle] where [picture_id] = ?";
		
		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1, pictureId);
			resultSet = prst.executeQuery();
			while (resultSet.next()) {
				arrayTid.add(resultSet.getInt(1));
			}
			// 关闭结果集
			resultSet.close();
			// 释放connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayTid;
	}
}
