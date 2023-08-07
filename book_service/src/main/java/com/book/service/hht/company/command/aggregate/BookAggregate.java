package com.book.service.hht.company.command.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.book.service.hht.company.command.command.CreateBookCommand;
import com.book.service.hht.company.command.command.DeleteBookCommand;
import com.book.service.hht.company.command.command.UpdateBookCommand;
import com.book.service.hht.company.command.event.BookCreatedEvent;
import com.book.service.hht.company.command.event.BookDeletedEvent;
import com.book.service.hht.company.command.event.BookUpdatedEvent;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Aggregate
@AllArgsConstructor
@NoArgsConstructor
public class BookAggregate {
	
	@AggregateIdentifier
	private String bookId;
	
	private String name;
	
	private String author;
	
	private Boolean isReady;
	
	
	@CommandHandler
	public void handle(CreateBookCommand createBookCommand) {
		BookCreatedEvent bookCreatedEvent = new BookCreatedEvent();
		BeanUtils.copyProperties(createBookCommand, bookCreatedEvent);
		AggregateLifecycle.apply(bookCreatedEvent);
	}
	
	@EventSourcingHandler
	public void on(BookCreatedEvent bookCreatedEvent) {
		this.bookId = bookCreatedEvent.getBookId();
		this.author = bookCreatedEvent.getAuthor();
		this.isReady = bookCreatedEvent.getIsReady();
		this.name = bookCreatedEvent.getName();
	}
	
	@CommandHandler
	public void handle(UpdateBookCommand updateBookCommand) {
		BookUpdatedEvent bookUpdatedEvent = new BookUpdatedEvent();
		BeanUtils.copyProperties(updateBookCommand, bookUpdatedEvent);
		AggregateLifecycle.apply(bookUpdatedEvent);
	}
	
	@EventSourcingHandler
	public void on(BookUpdatedEvent bookUpdatedEvent) {
		this.bookId = bookUpdatedEvent.getBookId();
		this.author = bookUpdatedEvent.getAuthor();
		this.isReady = bookUpdatedEvent.getIsReady();
		this.name = bookUpdatedEvent.getName();
	}
	
	@CommandHandler
	public void handle(DeleteBookCommand deleteBookCommand) {
		BookDeletedEvent bookDeletedEvent = new BookDeletedEvent();
		BeanUtils.copyProperties(deleteBookCommand, bookDeletedEvent);
		AggregateLifecycle.apply(bookDeletedEvent);
	}
	
	@EventSourcingHandler
	public void on(BookDeletedEvent bookDeletedEvent) {
		this.bookId = bookDeletedEvent.getBookId();
	}
	
}
