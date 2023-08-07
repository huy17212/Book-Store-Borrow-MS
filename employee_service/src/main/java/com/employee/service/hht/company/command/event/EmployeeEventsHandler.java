package com.employee.service.hht.company.command.event;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.service.hht.company.command.data.Employee;
import com.employee.service.hht.company.command.data.EmployeeRepository;

@Component
public class EmployeeEventsHandler {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@EventHandler
	public void on(EmployeeCreatedEvent event) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(event, employee);
		employeeRepository.save(employee);
	}
	
	@EventHandler
	public void on(EmployeeDeletedEvent employee) {
		employeeRepository.deleteById(employee.getEmployeeId());
	}
	
	@EventHandler
	public void on(EmployeeUpdatedEvent event) {
		Employee employee = employeeRepository.findById(event.getEmployeeId()).get();
		BeanUtils.copyProperties(event, employee);
		employeeRepository.save(employee);
	}
	
}
