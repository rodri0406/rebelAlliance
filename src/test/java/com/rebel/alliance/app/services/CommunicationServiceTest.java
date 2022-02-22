package com.rebel.alliance.app.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.rebel.alliance.app.entities.Coordinate;
import com.rebel.alliance.app.entities.SatelliteDataRequest;
import com.rebel.alliance.app.entities.SatelliteDataResponse;


@SpringBootTest
public class CommunicationServiceTest {
	
	@Autowired
	private  CommunicationService communicationService;

	@Test
	void processSatelliteDataTest() {
		List<SatelliteDataRequest> satelliteDataList = new ArrayList<>();
		
		satelliteDataList.add(new SatelliteDataRequest("kenobi", 100, Arrays.asList("", "este", "", "", "mensaje", "")));
		satelliteDataList.add(new SatelliteDataRequest("skywalker", 115.5,Arrays.asList("", "es", "", "", "secreto")));
		satelliteDataList.add(new SatelliteDataRequest("sato", 142.7, Arrays.asList("este", "", "un", "", "")));
		
		Coordinate coordinate = new Coordinate(-58.315252587138595, -69.55141837312165);
		
		SatelliteDataResponse response = communicationService.interpretSecretMessage(satelliteDataList);
		
		assertNotNull(response);
		assertTrue(response.getPosition().equals(coordinate));
		assertEquals("este es un mensaje secreto", response.getMessage());
		
		
	}
	

}
