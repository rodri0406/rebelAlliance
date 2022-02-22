package com.rebel.alliance.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Satellities")
public class Satellite {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String name;
	
	private double latitude;

	private double longitude;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<SatelliteDataReceived> satelliteDataReceive;
	
	
	public Satellite() {
		satelliteDataReceive = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void add(SatelliteDataReceived satelliteMessage) {
		this.satelliteDataReceive.add(satelliteMessage);
	}
	
	public void remove(SatelliteDataReceived satelliteMessage) {
		this.satelliteDataReceive.remove(satelliteMessage);
	}

	public List<SatelliteDataReceived> getSatelliteDataReceive() {
		return satelliteDataReceive;
	}

	public void setSatelliteDataReceive(List<SatelliteDataReceived> satelliteMessage) {
		this.satelliteDataReceive = satelliteMessage;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
