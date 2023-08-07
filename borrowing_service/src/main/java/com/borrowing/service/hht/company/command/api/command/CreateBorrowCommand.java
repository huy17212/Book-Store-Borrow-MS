package com.borrowing.service.hht.company.command.api.command;

import java.util.Date;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBorrowCommand {

	@TargetAggregateIdentifier
	private String id;
	private String bookId;
	private String employeeId;
	private Date borrowingDate;

}
