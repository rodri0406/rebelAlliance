package com.rebel.alliance.app.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.rebel.alliance.app.dao.ISatelliteDao;
import com.rebel.alliance.app.entities.Coordinate;
import com.rebel.alliance.app.entities.Satellite;
import com.rebel.alliance.app.entities.SatelliteDataReceived;
import com.rebel.alliance.app.entities.SatelliteDataRequest;
import com.rebel.alliance.app.entities.SatelliteDataResponse;
import com.rebel.alliance.app.exception.NotPossibleMessageException;

@Service
public class CommunicationService {
	
	@Autowired
	private ILocationService locationService;
	
	@Autowired
	private IMessageService messageService;
	
	@Autowired
	private ISatelliteDao satelliteDao;
	
	
	public SatelliteDataResponse interpretSecretMessage(List<SatelliteDataRequest> satelliteDataList) {
		double[] distances = satelliteDataList.stream().mapToDouble(s -> s.getDistance()).toArray();
			
		List<List<String>> messageList = satelliteDataList.stream().map(s -> s.getMessage()).collect(Collectors.toList());
		
		return generateResponseSecretMessage(distances, messageList);
		
	}
	
	public SatelliteDataResponse getSecretMessage() {
		
		List<Satellite> satelliteList = (List<Satellite>) satelliteDao.findAll();
		
		if(!isPossibleMessage(satelliteList)) {
			throw new NotPossibleMessageException("No hay informacion insuficiente");
		}
		
		double[] distances = satelliteList.stream().mapToDouble(s -> s.getSatelliteDataReceive().get(0).getDistance()).toArray();
		
		List<List<String>> messageList = satelliteList.stream().map(s -> Arrays.asList(s.getSatelliteDataReceive().get(0).getMessage().split(","))).collect(Collectors.toList());
		
		return generateResponseSecretMessage(distances, messageList);
	}
	
	private SatelliteDataResponse generateResponseSecretMessage(double[] distances , List<List<String>> messageList) {
		Coordinate coordinate = locationService.getLocation(distances);	
		String message = messageService.getMessage(messageList);
		
		return new SatelliteDataResponse(coordinate, message);
	}
	
	public void receiveSecretMessage(String satelliteName, SatelliteDataRequest request) {
		
		Satellite satellite = satelliteDao.findByName(satelliteName).orElseThrow(() -> new RuntimeException("Satellite " + satelliteName + "not exist " ));
		
		SatelliteDataReceived satelliteMessage = new SatelliteDataReceived();
	
		satelliteMessage.setMessage(StringUtils.collectionToDelimitedString(request.getMessage(), ","));
		
		satellite.add(satelliteMessage);
		
		satelliteDao.save(satellite);
		
	}
	
	private boolean isPossibleMessage(List<Satellite> satelliteList) {
		
		for(Satellite s : satelliteList) {
			if(s.getSatelliteDataReceive().isEmpty()) {
				return false;
			}
		}
		
		return true;
	}
	
}
