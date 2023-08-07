package com.borrowing.service.hht.company.command.api.data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "borrowing")
@Data
public class Borrowing {
	
	@Id
	private String id;
	private String bookId;
	private String employeeId;
	private Date borrowingDate;
	private Date returnDate;
	
	
}
