package com.borrowing.service.hht.company.command.api.controller;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public abstract class DeleteBorrowCommand {

	@TargetAggregateIdentifier
	private String id;

	public DeleteBorrowCommand(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
