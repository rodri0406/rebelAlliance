package com.rebel.alliance.app.entities;

public class SatelliteDataResponse {
	
	private Coordinate position;
	private String message;
	
	public SatelliteDataResponse(Coordinate position, String message) {
		super();
		this.position = position;
		this.message = message;
	}
	
	public Coordinate getPosition() {
		return position;
	}
	
	public void setPosition(Coordinate position) {
		this.position = position;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	

}
