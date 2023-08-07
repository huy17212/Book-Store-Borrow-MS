package com.book.service.hht.company.command.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.service.hht.company.command.command.CreateBookCommand;
import com.book.service.hht.company.command.command.DeleteBookCommand;
import com.book.service.hht.company.command.command.UpdateBookCommand;
import com.book.service.hht.company.command.model.BookRequestModel;

@RestController
@RequestMapping("api/v1/books")
public class BookCommandController {
	
	@Autowired
	private CommandGateway commandGateway;
	
	@PostMapping
	public String addBook(@RequestBody BookRequestModel model) {
		CreateBookCommand command = new CreateBookCommand(UUID.randomUUID().toString(), model.getName(), model.getAuthor(), true);
		commandGateway.sendAndWait(command);
		return "added Book successfully";
	}
	
	@PutMapping
	public String updateBook(@RequestBody BookRequestModel model) {
		UpdateBookCommand command = new UpdateBookCommand(model.getBookId(), model.getName(), model.getAuthor(), true);
		commandGateway.sendAndWait(command);
		return "updated Book successfully";
	}
	
	@DeleteMapping({"/{id}"})
	public String deleteBook(@PathVariable String id) {
		DeleteBookCommand command = new DeleteBookCommand(id);
		commandGateway.sendAndWait(command);
		return "added Book successfully";
	}
	
	
}
