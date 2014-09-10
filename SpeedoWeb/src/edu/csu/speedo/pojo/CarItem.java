package edu.csu.speedo.pojo;

import edu.csu.speedo.dto.ProductDto;

public class CarItem {

	private int value;
	private ProductDto productDto;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public ProductDto getProductDto() {
		return productDto;
	}
	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}
}
