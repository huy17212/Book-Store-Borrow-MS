package com.book.service.hht.company.command.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	
	
	@Id
	private String bookId;
	
	private String name;
	
	private String author;
	
	private Boolean isReady;
	
	
}
