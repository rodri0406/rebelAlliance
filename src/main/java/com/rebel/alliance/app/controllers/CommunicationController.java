package com.rebel.alliance.app.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rebel.alliance.app.entities.SatelliteDataRequest;
import com.rebel.alliance.app.entities.SatelliteDataResponse;
import com.rebel.alliance.app.entities.TopSecretRequest;
import com.rebel.alliance.app.exception.NotPossibleMessageException;
import com.rebel.alliance.app.services.CommunicationService;


@RestController
public class CommunicationController {
	
	@Autowired
	private CommunicationService communicationService;
	
	@PostMapping("/topsecret/")
	public ResponseEntity<SatelliteDataResponse> interpretSecretMessage(@RequestBody TopSecretRequest request) {
		return new ResponseEntity<SatelliteDataResponse>(communicationService.interpretSecretMessage(request.getSatellites()), HttpStatus.OK);
	}
	
	@GetMapping("/topsecret_split/")
	public ResponseEntity<SatelliteDataResponse> getSecretMessage() {
		return new ResponseEntity<SatelliteDataResponse>(communicationService.getSecretMessage(), HttpStatus.OK);
	}
	
	@PostMapping("/topsecret_split/{satellite_name}")
	public ResponseEntity<Object> receiveSecretMessage(@PathVariable(value = "satellite_name") String satelliteName, @RequestBody SatelliteDataRequest request) {
		communicationService.receiveSecretMessage(satelliteName, request);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@ExceptionHandler(NotPossibleMessageException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Map<String, Map<String, String>> error(NotPossibleMessageException ex) {
		Map<String, String> map = new HashMap<>();
		Map<String, Map<String, String>> errors = new HashMap<>();

		map.put("error", ex.getMessage());

		errors.put("errores", map);
		return errors;
	}
	 
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Map<String, Map<String, String>> error(Exception ex) {
		return null;
	}
}
