package com.borrowing.service.hht.company.command.api.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendMessageCommand {
	
	@TargetAggregateIdentifier
	private String id;
	private String employeeId;
	private String message;
	
}
