package com.commom.service.hht.company.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRollBackStatusEvent {
	private String bookId;
	private Boolean isReady;
	private String employeeId;
	private String borrowId;
}
