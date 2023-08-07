package com.employee.service.hht.company.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteEmployeeCommand {
	
	private String employeeId;
	
}
