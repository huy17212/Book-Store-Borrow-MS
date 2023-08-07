package com.commom.service.hht.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseCommonModel {
	
	private String employeeId;
	private String firstName;
	private String lastName;
	private String kin;
	private Boolean isDisciplined;
	
}
