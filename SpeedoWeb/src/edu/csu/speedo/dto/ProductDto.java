package edu.csu.speedo.dto;

public class ProductDto {

	private int productId;
	private int productPrice;
	//产品总量
	private int productAccount;
	//产品销量
	private int productAmount;
	private String productColor;
	private String productSize;
	private String productCollar;
	private String productAge;
	private int productPictureId;
	private String imgSrc;
	private String productName;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductAccount() {
		return productAccount;
	}
	public void setProductAccount(int productAccount) {
		this.productAccount = productAccount;
	}
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public String getProductSize() {
		return productSize;
	}
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	public String getProductCollar() {
		return productCollar;
	}
	public void setProductCollar(String productCollar) {
		this.productCollar = productCollar;
	}
	public String getProductAge() {
		return productAge;
	}
	public void setProductAge(String productAge) {
		this.productAge = productAge;
	}
	public int getProductPictureId() {
		return productPictureId;
	}
	public void setProductPictureId(int productPictureId) {
		this.productPictureId = productPictureId;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
}
