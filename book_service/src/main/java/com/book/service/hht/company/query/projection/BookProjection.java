package com.book.service.hht.company.query.projection;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.book.service.hht.company.command.data.Book;
import com.book.service.hht.company.command.data.BookRepository;
import com.book.service.hht.company.query.model.BookResponseModel;
import com.book.service.hht.company.query.queries.GetAllBooksQuery;
import com.book.service.hht.company.query.queries.GetBookQuery;

@Component
public class BookProjection {

	@Autowired
	private BookRepository bookRepository;

	@QueryHandler
	public BookResponseModel handle(GetBookQuery getBookQuery) {
		BookResponseModel model = new BookResponseModel();
		Book book = bookRepository.getById(getBookQuery.getBookId());
		BeanUtils.copyProperties(book, model);
		return model;
	}

	@QueryHandler
	public List<BookResponseModel> handle(GetAllBooksQuery getAllBooksQuery) {
		List<BookResponseModel> listBookResponseModels = new ArrayList<>();
		List<Book> list = bookRepository.findAll();

		list.stream().forEach(item -> {
			BookResponseModel model = new BookResponseModel();
			BeanUtils.copyProperties(item, model);
			listBookResponseModels.add(model);
		});

		return listBookResponseModels;
	}

}
