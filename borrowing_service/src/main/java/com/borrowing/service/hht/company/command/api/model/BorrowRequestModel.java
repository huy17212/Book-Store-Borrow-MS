package com.borrowing.service.hht.company.command.api.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowRequestModel {
	
	private String id;
	
	private String bookId;
	
	private String employeeId;
	
	private Date borrowingDate;
	
	private Date returnDate;
	
	
	
}	
