package edu.csu.speedo.dto;

public class OrderInfoDto {


	private int orderInfoId;
	private int orderId;
	private int productId;
	private int count;
	public int getOrderInfoId() {
		return orderInfoId;
	}
	public void setOrderInfoId(int orderInfoId) {
		this.orderInfoId = orderInfoId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
