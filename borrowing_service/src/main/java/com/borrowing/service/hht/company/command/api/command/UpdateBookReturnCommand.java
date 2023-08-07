package com.borrowing.service.hht.company.command.api.command;

import java.util.Date;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookReturnCommand {
	
	@TargetAggregateIdentifier
	private String id;
	private String bookId;
	private String employee;
	private Date returnDate;
	
}
