package com.book.service.hht.company.query.controller;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.service.hht.company.query.model.BookResponseModel;
import com.book.service.hht.company.query.queries.GetAllBooksQuery;
import com.book.service.hht.company.query.queries.GetBookQuery;

@RestController
@RequestMapping("/api/v1/books")
public class BookQueryController {

	@Autowired
	private QueryGateway queryGateway;
	
	@GetMapping("/{bookId}")
	public BookResponseModel getBookDetail(@PathVariable String bookId) {
		GetBookQuery getBookQuery = new GetBookQuery();
		getBookQuery.setBookId(bookId);
		
		BookResponseModel bookResponseModel = queryGateway.query(getBookQuery, BookResponseModel.class).join();
		return bookResponseModel;
	}
	
	@GetMapping
	public List<BookResponseModel> getAllBooks(){
		GetAllBooksQuery getAllBooksQuery = new GetAllBooksQuery();
		List<BookResponseModel> list = 
				queryGateway.query(getAllBooksQuery, ResponseTypes.multipleInstancesOf(BookResponseModel.class)).join();
		return list;
		
	}
	
}
