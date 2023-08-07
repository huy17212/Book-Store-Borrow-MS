package com.borrowing.service.hht.company.query.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowingResponseModel {
	
	private String id;
	private String bookId;
	private String employeeId;
	private Date borrowingDate;
	private Date returnDate;
	private String nameBook;
	private String nameEmployee;
	
}
