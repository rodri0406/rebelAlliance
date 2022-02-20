package com.rebel.alliance.app.services;

import com.rebel.alliance.app.entities.Coordinate;

public interface ILocationService {
	
	Coordinate getLocation(double[] distances);

}
