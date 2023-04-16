package com.example.eCommerce.domain;

import java.util.List;

public class PhoneHeaderResponse {
	
	private String id;
	private String name;
	private String colorOptions;
	private List<SellerInfo> sellerInfo;
	private String ramOptions;
	private String brand;
	private String warranty;
	
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
	public String getColorOptions() {
		return colorOptions;
	}
	public void setColorOptions(String colorOptions) {
		this.colorOptions = colorOptions;
	}
	public List<SellerInfo> getSellerInfo() {
		return sellerInfo;
	}
	public void setSellerInfo(List<SellerInfo> sellerInfo) {
		this.sellerInfo = sellerInfo;
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
	public String getWarranty() {
		return warranty;
	}
	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}
	
	

}
