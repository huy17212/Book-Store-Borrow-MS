package com.employee.service.hht.company.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestModel {
	
	private String employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private String kin;
	
	private Boolean isDisciplined;
	
	
}
