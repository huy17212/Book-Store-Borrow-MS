package com.commom.service.hht.company.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RollBackStatusBookCommand {

	@TargetAggregateIdentifier
	private String bookId;
	private Boolean isReady;
	private String employeeId;
	private String borrowId;

}
