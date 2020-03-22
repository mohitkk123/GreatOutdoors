package com.cg.greatoutdoors.dto;

public class Product {
	
	private String productName,productDescription,productId,manufacturer;
	private double productPrice;
	public Product(String productName, String productDescription, String productId, String manufacturer,
			double productPrice) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.productId = productId;
		this.manufacturer = manufacturer;
		this.productPrice = productPrice;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public Product(String productName, String productDescription, String productId, double productPrice) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.productId = productId;
		this.productPrice = productPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	

}
