package com.example.eCommerce.domain;

public class SellerInfo {
	
	private String id;
	private String name;
	private String price;
	private int availableQy;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getAvailableQy() {
		return availableQy;
	}
	public void setAvailableQy(int availableQy) {
		this.availableQy = availableQy;
	}
	
	
}
