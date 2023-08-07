package com.borrowing.service.hht.company.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowSendMessageEvent {

	private String id;
	private String employeeId;
	private String message;

}
