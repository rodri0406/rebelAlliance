package com.rebel.alliance.app.entities;

import java.io.Serializable;
import java.util.List;

public class SatelliteDataRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private double distance;
	private List<String> message;
	
	
	public SatelliteDataRequest(String name, double distance, List<String> message) {
		this.name = name;
		this.distance = distance;
		this.message = message;
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
	public List<String> getMessage() {
		return message;
	}
	public void setMessage(List<String> message) {
		this.message = message;
	}
}
