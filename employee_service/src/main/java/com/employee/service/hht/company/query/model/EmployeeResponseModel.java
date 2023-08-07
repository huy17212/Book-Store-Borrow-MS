package com.employee.service.hht.company.query.model;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseModel {
	
	private String employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private String kin;
	
	private Boolean isDisciplined;
	
}
