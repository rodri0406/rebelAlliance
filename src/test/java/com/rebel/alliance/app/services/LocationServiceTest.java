package com.rebel.alliance.app.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.rebel.alliance.app.entities.Coordinate;
import com.rebel.alliance.app.entities.SatelliteDataRequest;


@SpringBootTest
public class LocationServiceTest {
	
	@Autowired
	private LocationService locationService;

	@Test
	void calculateCoordinateTest() {
		List<SatelliteDataRequest> satelliteDataList = new ArrayList<>();
		satelliteDataList.add(new SatelliteDataRequest("kenobi", 100, new ArrayList<>()));
		satelliteDataList.add(new SatelliteDataRequest("skywalker", 115.5, new ArrayList<>()));
		satelliteDataList.add(new SatelliteDataRequest("sato", 142.7, new ArrayList<>()));
		
		double[] distances = satelliteDataList.stream().mapToDouble(satellite -> satellite.getDistance()).toArray();
		
		Coordinate coordinate = locationService.getLocation(distances);	
		
		assertNotNull(coordinate);
		assertEquals(coordinate.getX(), -58.315252587138595);
		assertEquals(coordinate.getY(), -69.55141837312165);
		
	}


}
