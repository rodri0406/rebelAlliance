package com.rebel.alliance.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class MessageService implements IMessageService {

	@Override
	public String getMessage(List<List<String>> messageList) {
		List<String> messageAll = getAllMessages(messageList);
		String messageFinal = interpretMessage(messageAll);
		return messageFinal;
	}
	
	
	public String interpretMessage(List<String> messageList) {
		List<String> messageFinal = messageList.stream().filter(m -> !"".equals(m)).distinct().collect(Collectors.toList());
		return messageFinal.toString().replace(",", "").replace("[", "").replace("]", "");
		
	}
	
	public List<String> getAllMessages(List<List<String>> messageList) {
		List<String> allMessagesList = new ArrayList<>();
		
		int maxIndex = getMaxIndex(messageList);
		
		for(int i = 0; i < maxIndex; i++) {
			for(List<String> mList: messageList) {
				if(mList.size() > i ) {
					allMessagesList.add(mList.get(i));
				}
			}
		}
		
		return allMessagesList;
	}
	

	public int getMaxIndex(List<List<String>> messageList) {
		int maxIndex = messageList.get(0).size();
		
		for(int i = 1; i< messageList.size(); i++) {
			 if(maxIndex < messageList.get(i).size()){
				 maxIndex = messageList.get(i).size();
			 }
		}
		
		return maxIndex;
	}

}
