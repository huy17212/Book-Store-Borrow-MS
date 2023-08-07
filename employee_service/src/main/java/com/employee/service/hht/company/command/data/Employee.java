package com.employee.service.hht.company.command.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	private String employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private String kin;
	
	private Boolean isDisciplined;
	
}
