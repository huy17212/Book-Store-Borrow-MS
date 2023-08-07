package com.borrowing.service.hht.company.command.api.service;

import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.borrowing.service.hht.company.command.api.data.BorrowRepository;
import com.borrowing.service.hht.company.command.api.model.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@EnableBinding(Source.class)
public class BorrowService implements IBorrowService {

	@Autowired
	private BorrowRepository repository;

	@Autowired
	private MessageChannel output;

	@Override
	public void sendMessage(Message message) {
		try {

			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(message);
			output.send(MessageBuilder.withPayload(json).build());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String findIdBorrowing(String employeeId, String bookId) {
		// TODO Auto-generated method stub
		return null;
	}

}
