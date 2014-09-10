package edu.csu.speedo.dto;

import java.sql.Date;
import java.util.ArrayList;

import edu.csu.speedo.dao.UserInfoDao;

public class OrderDto {

	private int orderId;
	private String phoneNumber;
	private int totalPrice;
	private int orderUserId;
	private Date orderDate;
	private String transportId;
	private String destination;
	private byte orderCompeleteTag;
	private String orderDescription;
	private int orderZip;
	private String orderName;
	private ArrayList<OrderInfoDto> arrayListOrderInfoDto;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getTransportId() {
		return transportId;
	}
	public void setTransportId(String transportId) {
		this.transportId = transportId;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public byte getOrderCompeleteTag() {
		return orderCompeleteTag;
	}
	public void setOrderCompeleteTag(byte orderCompeleteTag) {
		this.orderCompeleteTag = orderCompeleteTag;
	}
	public String getOrderDescription() {
		return orderDescription;
	}
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}
	public ArrayList<OrderInfoDto> getArrayListOrderInfoDto() {
		return arrayListOrderInfoDto;
	}
	public void setArrayListOrderInfoDto(
			ArrayList<OrderInfoDto> arrayListOrderInfoDto) {
		this.arrayListOrderInfoDto = arrayListOrderInfoDto;
	}
	public int getOrderUserId() {
		return orderUserId;
	}
	public void setOrderUserId(int orderUserId) {
		this.orderUserId = orderUserId;
	}
	public int getOrderZip() {
		return orderZip;
	}
	public void setOrderZip(int orderZip) {
		this.orderZip = orderZip;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
}
