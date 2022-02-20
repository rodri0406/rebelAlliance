package com.rebel.alliance.app.entities;

import java.util.List;

public class SatelliteDataRequest {
	
	private String name;
	private double distance;
	private List<String> messageList;
	
	
	public SatelliteDataRequest(String name, double distance, List<String> messageList) {
		this.name = name;
		this.distance = distance;
		this.messageList = messageList;
	}

	public SatelliteDataRequest() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public List<String> getMessageList() {
		return messageList;
	}
	public void setMessageList(List<String> messageList) {
		this.messageList = messageList;
	}
	
	

}
