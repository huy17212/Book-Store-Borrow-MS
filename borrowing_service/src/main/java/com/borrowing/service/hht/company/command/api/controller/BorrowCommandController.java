package com.borrowing.service.hht.company.command.api.controller;

import java.util.UUID;

import javax.xml.transform.Source;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.borrowing.service.hht.company.command.api.model.BorrowRequestModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1/borrowing")
//@EnableBinding(Source.class)
public class BorrowCommandController {

//	@Autowired
//	private CommandGateway commandGateway;
//	
//	@Autowired
//	private IBorrowService borrowService;
//	
//	@Autowired
//	private MessageChannel output;
//	
//	@PostMapping
//	public String addBookBorrowing(@RequestBody BorrowRequestModel model) {
//		try {
//			CreateBorrowCommand command = 
//					new CreateBorrowCommand(model.getBookId(), model.getEmployeeId(), new Date(),UUID.randomUUID().toString());
//				commandGateway.sendAndWait(command);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		
//		return "Book borrowing added";
//	}
//	@PutMapping
//	public String updateBookReturn(@RequestBody BorrowRequestModel model) {
//		UpdateBookReturnCommand command = new UpdateBookReturnCommand(borrowService.findIdBorrowing(model.getEmployeeId(), model.getBookId()), model.getBookId(),model.getEmployeeId(),new Date());
//		commandGateway.sendAndWait(command);
//		return "Book returned";
//	}
//	@PostMapping("/sendMessage")
//	public void SendMessage(@RequestBody Message message) {
//		try {
//			
//			ObjectMapper mapper = new ObjectMapper();
//			String json = mapper.writeValueAsString(message);
//			output.send(MessageBuilder.withPayload(json).build());
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
}