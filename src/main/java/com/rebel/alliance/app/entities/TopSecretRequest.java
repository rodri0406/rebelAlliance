package com.rebel.alliance.app.entities;

import java.io.Serializable;
import java.util.List;

public class TopSecretRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<SatelliteDataRequest> satellites;

	
	public TopSecretRequest() {
		super();
	}


	public List<SatelliteDataRequest> getSatellites() {
		return satellites;
	}


	public void setSatellites(List<SatelliteDataRequest> satellites) {
		this.satellites = satellites;
	}	

}
