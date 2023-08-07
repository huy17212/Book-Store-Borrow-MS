package com.book.service.hht.company.command.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDeletedEvent {
	
	private String bookId;

	private String name;

	private String author;

	private Boolean isReady;
	
}
