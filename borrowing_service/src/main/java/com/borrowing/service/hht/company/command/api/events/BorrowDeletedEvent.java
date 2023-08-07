package com.borrowing.service.hht.company.command.api.events;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowDeletedEvent {
	private String id;
}
