package edu.csu.speedo.dao;

import java.sql.Connection;

import edu.csu.speedo.dbutil.SimpleConnetionPool;


/**
 * @author tangbutian
 * Dao的父类用于获得Connection
 */
public class BaseDao {
	Connection connection = null;

	// 设置数据库连接字符串
	String urlString = "jdbc:sqlserver://10.16.10.88:1433;databaseName=SpeedoWeb";

	public BaseDao() {
		// TODO Auto-generated constructor stub
		//
		SimpleConnetionPool.setUrl(urlString);
		//
		SimpleConnetionPool.setUser("sa");
		//
		SimpleConnetionPool.setPassword("123");

		connection = SimpleConnetionPool.getConnection();

	}

}
