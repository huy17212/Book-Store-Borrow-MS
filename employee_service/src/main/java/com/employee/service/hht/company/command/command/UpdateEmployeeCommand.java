package com.employee.service.hht.company.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeCommand {
	
	private String employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private String kin;
	
	private Boolean isDisciplined;
	
	
}
