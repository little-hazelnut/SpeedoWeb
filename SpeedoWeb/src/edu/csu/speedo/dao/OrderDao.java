package edu.csu.speedo.dao;

import java.util.ArrayList;
import java.sql.*;

import edu.csu.speedo.dto.OrderDto;

/**
 * @author tangbutian
 *
 */
public class OrderDao extends BaseDao {

	//查询OderID对应的OrderDto
	public OrderDto getOrderDtoByOrderId(int orderId){
		OrderDto od = new OrderDto();
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "select * from [Order] where [order_id] = ?";
		try{
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1, orderId);
			prst.executeQuery();
			while(resultSet.next()) {
				od.setOrderId(orderId);
				od.setPhoneNumber(resultSet.getString("phone_number"));
				od.setTotalPrice(resultSet.getInt("total_price"));
				od.setOrderUserId(resultSet.getInt("user_id"));
				od.setOrderDate(resultSet.getDate("order_date"));
				od.setTransportId(resultSet.getString("transport_id"));
				od.setDestination(resultSet.getString("destination"));
				od.setOrderCompeleteTag(resultSet.getByte("order_complete_tag"));
				od.setOrderDescription(resultSet.getString("order_description"));
				od.setOrderZip(resultSet.getInt("zip"));
				od.setOrderName(resultSet.getString("order_name"));
				od.setArrayListOrderInfoDto(new OrderInfoDao().getOrderInfoDtoByOrderId(resultSet.getInt("orderId")));
			}
			resultSet.close();
			prst.close();
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return od;
	}
	
	//查询用户Id对应的所有OrderDto
	public ArrayList<OrderDto> getAllOrderDtoByUserId(int userId){
		ArrayList<OrderDto> arrayod = new ArrayList<OrderDto>();
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		String sqlString = "select * from [Order] where [user_id] = ?";
		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1, userId);
			resultSet = prst.executeQuery();
			while(resultSet.next()) {
				OrderDto od = new OrderDto();
				od.setOrderId(resultSet.getInt("orderId"));
				od.setPhoneNumber(resultSet.getString("phone_number"));
				od.setTotalPrice(resultSet.getInt("total_price"));
				od.setOrderUserId(userId);
				od.setOrderDate(resultSet.getDate("order_date"));
				od.setTransportId(resultSet.getString("transport_id"));
				od.setDestination(resultSet.getString("destination"));
				od.setOrderCompeleteTag(resultSet.getByte("order_complete_tag"));
				od.setOrderDescription(resultSet.getString("order_description"));
				od.setOrderZip(resultSet.getInt("zip"));
				od.setOrderName(resultSet.getString("order_name"));
				od.setArrayListOrderInfoDto(new OrderInfoDao().getOrderInfoDtoByOrderId(resultSet.getInt("orderId")));
				arrayod.add(od);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayod;
	}
	
	//添加新Order
	public int addOder(OrderDto orderDto){
		int result = -1;
		PreparedStatement prst = null;
		String sqlString = "insert into [Order] values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			prst = super.connection.prepareStatement(sqlString);
			prst.setInt(1, orderDto.getOrderId());
			prst.setString(2, orderDto.getPhoneNumber());
			prst.setInt(3, orderDto.getTotalPrice());
			prst.setInt(4, orderDto.getOrderUserId());
			prst.setDate(5, orderDto.getOrderDate());
			prst.setString(6, orderDto.getTransportId());
			prst.setString(7, orderDto.getDestination());
			prst.setByte(8, orderDto.getOrderCompeleteTag());
			prst.setString(9, orderDto.getOrderDescription());
			prst.setString(10, orderDto.getOrderName());
			prst.setInt(11, orderDto.getOrderZip());
			result = prst.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result; 
	}
} 
