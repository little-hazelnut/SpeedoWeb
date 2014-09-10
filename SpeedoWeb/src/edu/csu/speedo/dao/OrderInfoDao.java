package edu.csu.speedo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.csu.speedo.dto.OrderInfoDto;

/**
 * @author tangbutian
 *
 */
public class OrderInfoDao extends BaseDao 
{

	//通过订单id返回该订单下的所有OderInfo集合
	public ArrayList<OrderInfoDto> getOrderInfoDtoByOrderId(int orderId)
	{
		ArrayList<OrderInfoDto> arrayOrder = new ArrayList<OrderInfoDto>();
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "select * from [OderInfo] where [order_id] = ?";
	
		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1, orderId);
			resultSet = prst.executeQuery();
			while (resultSet.next()) {
				OrderInfoDto oid = new OrderInfoDto();
				oid.setOrderInfoId(resultSet.getInt("orderinfo_id"));
				oid.setOrderId(orderId);
				oid.setProductId(resultSet.getInt("product_id"));
				oid.setCount(resultSet.getInt("count"));
				arrayOrder.add(oid);
			}
			// 关闭结果集
			resultSet.close();
			// 释放connection
			connection.close();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayOrder;
	}

	//添加新的OderInfo
	public int addOrderInfo(OrderInfoDto orderInfoDto)
	{
		int result = -1;
		PreparedStatement prst = null;
		String sqlString = "insert into [OrderInfo] values(?,?,?)";
		try {
			prst = super.connection.prepareStatement(sqlString);
			//prst.setInt(1, orderInfoDto.getOrderInfoId());
			prst.setInt(1, orderInfoDto.getOrderId());
			prst.setInt(2, orderInfoDto.getProductId());
			prst.setInt(3,orderInfoDto.getCount());
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
