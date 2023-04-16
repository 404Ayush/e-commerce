package com.example.eCommerce.domain;

public class ProductHomeResponse {
	private String id;
	private String name;
	private String ramOptions;
	private String brand;
	
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
	public String getRamOptions() {
		return ramOptions;
	}
	public void setRamOptions(String ramOptions) {
		this.ramOptions = ramOptions;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
}
