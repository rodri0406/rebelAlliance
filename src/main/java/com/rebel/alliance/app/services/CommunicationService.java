package com.rebel.alliance.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebel.alliance.app.entities.Coordinate;
import com.rebel.alliance.app.entities.SatelliteDataRequest;
import com.rebel.alliance.app.entities.SatelliteDataResponse;

@Service
public class CommunicationService {
	
	@Autowired
	private ILocationService locationService;
	

	@Autowired
	private IMessageService messageService;
	
	
	public SatelliteDataResponse processSatelliteData(List<SatelliteDataRequest> satelliteDataList) {
		double[] distances = satelliteDataList.stream().mapToDouble(s -> s.getDistance()).toArray();
		
		Coordinate coordinate = locationService.getLocation(distances);
		
		List<List<String>> messageList = satelliteDataList.stream().map(s -> s.getMessageList()).collect(Collectors.toList());
		
		String message = messageService.getMessage(messageList);
		
		return new SatelliteDataResponse(coordinate, message);
		
	}
	
}
