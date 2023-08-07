package com.book.service.hht.company.command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookCommand {
	
	@TargetAggregateIdentifier
	private String bookId;

	private String name;

	private String author;

	private Boolean isReady;

}
