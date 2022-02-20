package com.rebel.alliance.app.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.rebel.alliance.app.entities.SatelliteDataRequest;


@SpringBootTest
public class MessageServiceTest {
	
	@Autowired
	private MessageService messageService;

	@Test
	void interpretMessageTest() {
		List<SatelliteDataRequest> satelliteDataList = new ArrayList<>();
		
		satelliteDataList.add(new SatelliteDataRequest("kenobi", 100, Arrays.asList("", "este", "", "", "mensaje", "")));
		satelliteDataList.add(new SatelliteDataRequest("skywalker", 115.5,Arrays.asList("", "es", "", "", "secreto")));
		satelliteDataList.add(new SatelliteDataRequest("sato", 142.7, Arrays.asList("este", "", "un", "", "")));
		
		List<List<String>> messageList = satelliteDataList.stream().map(s -> s.getMessageList()).collect(Collectors.toList());
		
		List<String> messageAll = messageService.getAllMessages(messageList);
		
		String messageFinal = messageService.interpretMessage(messageAll);
		
		assertEquals("este es un mensaje secreto", messageFinal.toString());
		
		
	}
	
	@Test
	void maxIndexTest() {
		List<SatelliteDataRequest> satelliteDataList = new ArrayList<>();
		
		satelliteDataList.add(new SatelliteDataRequest("kenobi", 100, Arrays.asList("este", "", "", "mensaje", "")));
		satelliteDataList.add(new SatelliteDataRequest("skywalker", 115.5,Arrays.asList("", "es", "", "", "secreto")));
		satelliteDataList.add(new SatelliteDataRequest("sato", 142.7, Arrays.asList("","este", "", "un", "", "")));
		
		List<List<String>> messageList = satelliteDataList.stream().map(s -> s.getMessageList()).collect(Collectors.toList());
			
		int maxindex = messageService.getMaxIndex(messageList);
		
		
		assertEquals(6, maxindex);
		
		
	}
	
	@Test
	void allmessageListTest() {
		List<SatelliteDataRequest> satelliteDataList = new ArrayList<>();
		
		satelliteDataList.add(new SatelliteDataRequest("kenobi", 100, Arrays.asList("este", "", "", "mensaje", "")));
		satelliteDataList.add(new SatelliteDataRequest("skywalker", 115.5,Arrays.asList("", "es", "", "", "secreto")));
		satelliteDataList.add(new SatelliteDataRequest("sato", 142.7, Arrays.asList("","este", "", "un", "", "")));
		
		List<List<String>> messageList = satelliteDataList.stream().map(s -> s.getMessageList()).collect(Collectors.toList());
		
		List<String> messageAll = messageService.getAllMessages(messageList);
		
		assertEquals("[este, , , , es, este, , , , mensaje, , un, , secreto, , ]", messageAll.toString());
		
	}


}
