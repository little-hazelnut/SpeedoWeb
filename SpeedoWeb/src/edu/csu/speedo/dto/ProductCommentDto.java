package edu.csu.speedo.dto;

public class ProductCommentDto {

	private int productCommentId;
	private int productId;
	private int productCommentScore;
	private String productCommentDescription;
	private int productCommentUserId;
	public int getProductCommentId() {
		return productCommentId;
	}
	public void setProductCommentId(int productCommentId) {
		this.productCommentId = productCommentId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductCommentScore() {
		return productCommentScore;
	}
	public void setProductCommentScore(int productCommentScore) {
		this.productCommentScore = productCommentScore;
	}
	public String getProductCommentDescription() {
		return productCommentDescription;
	}
	public void setProductCommentDescription(String productCommentDescription) {
		this.productCommentDescription = productCommentDescription;
	}
	public int getProductCommentUserId() {
		return productCommentUserId;
	}
	public void setProductCommentUserId(int productCommentUserId) {
		this.productCommentUserId = productCommentUserId;
	}
	
}
