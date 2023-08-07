package com.employee.service.hht.company.command.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.employee.service.hht.company.command.command.CreateEmployeeCommand;
import com.employee.service.hht.company.command.command.DeleteEmployeeCommand;
import com.employee.service.hht.company.command.command.UpdateEmployeeCommand;
import com.employee.service.hht.company.command.event.EmployeeCreatedEvent;
import com.employee.service.hht.company.command.event.EmployeeDeletedEvent;
import com.employee.service.hht.company.command.event.EmployeeUpdatedEvent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Aggregate
@Data
public class EmployeeAggregate {
	
	@AggregateIdentifier
	private String employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private String kin;
	
	private Boolean isDisciplined;
	
	
	@CommandHandler
	public void handle(CreateEmployeeCommand createEmployeeCommand) {
		EmployeeCreatedEvent employeeCreatedEvent = new EmployeeCreatedEvent();
		BeanUtils.copyProperties(createEmployeeCommand, employeeCreatedEvent);
		AggregateLifecycle.apply(employeeCreatedEvent);
	}
	
	@EventSourcingHandler
	public void on(EmployeeCreatedEvent employeeCreatedEvent) {
		this.employeeId = employeeCreatedEvent.getEmployeeId();
		this.firstName = employeeCreatedEvent.getFirstName();
		this.lastName = employeeCreatedEvent.getLastName();
		this.kin = employeeCreatedEvent.getKin();
		this.isDisciplined = employeeCreatedEvent.getIsDisciplined();
	}
	
	@CommandHandler
	public void handle(UpdateEmployeeCommand updateEmployeeCommand) {
		EmployeeUpdatedEvent employeeUpdatedEvent = new EmployeeUpdatedEvent();
		BeanUtils.copyProperties(updateEmployeeCommand, employeeUpdatedEvent);
		AggregateLifecycle.apply(employeeUpdatedEvent);
	}
	
	@EventSourcingHandler
	public void on(EmployeeUpdatedEvent employeeUpdatedEvent) {
		this.employeeId = employeeUpdatedEvent.getEmployeeId();
		this.firstName = employeeUpdatedEvent.getFirstName();
		this.lastName = employeeUpdatedEvent.getLastName();
		this.kin = employeeUpdatedEvent.getKin();
		this.isDisciplined = employeeUpdatedEvent.getIsDisciplined();
	}
	
	@CommandHandler
	public void handle(DeleteEmployeeCommand deleteEmployeeCommand) {
		EmployeeDeletedEvent employeeDeletedEvent = new EmployeeDeletedEvent();
		BeanUtils.copyProperties(deleteEmployeeCommand, employeeDeletedEvent);
		AggregateLifecycle.apply(employeeDeletedEvent);
	}
	
	@EventSourcingHandler
	public void on(EmployeeDeletedEvent employeeDeletedEvent) {
		this.employeeId = employeeDeletedEvent.getEmployeeId();
	}
	
}
