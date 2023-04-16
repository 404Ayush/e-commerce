package com.example.eCommerce.domain;

public class PhoneDetailsResponse {
	private String displaySize;
	private String displayType;
	private String processor;
	private String battery;
	private PhoneSize size;
	private String speakerType;
	private String speakerComment;
	private String boxContent;
	public String getDisplaySize() {
		return displaySize;
	}
	public void setDisplaySize(String displaySize) {
		this.displaySize = displaySize;
	}
	public String getDisplayType() {
		return displayType;
	}
	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	}
	public PhoneSize getSize() {
		return size;
	}
	public void setSize(PhoneSize size) {
		this.size = size;
	}
	public String getSpeakerType() {
		return speakerType;
	}
	public void setSpeakerType(String speakerType) {
		this.speakerType = speakerType;
	}
	public String getSpeakerComment() {
		return speakerComment;
	}
	public void setSpeakerComment(String speakerComment) {
		this.speakerComment = speakerComment;
	}
	public String getBoxContent() {
		return boxContent;
	}
	public void setBoxContent(String boxContent) {
		this.boxContent = boxContent;
	}
	
	
}
