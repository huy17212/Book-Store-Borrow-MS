package com.employee.service.hht.company.query.controller;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.service.hht.company.query.model.EmployeeResponseModel;
import com.employee.service.hht.company.query.queries.GetAllEmployeesQuery;
import com.employee.service.hht.company.query.queries.getEmployeeQuery;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeQueryController {
	
	@Autowired
	private QueryGateway queryGateway;
	
	@GetMapping("/{employeeId}")
	public EmployeeResponseModel getBookDetail(@PathVariable String employeeId) {
		getEmployeeQuery getEmployeeQuery = new getEmployeeQuery();
		getEmployeeQuery.setEmployeeId(employeeId);
		EmployeeResponseModel employeeResponseModel = queryGateway.query(getEmployeeQuery, EmployeeResponseModel.class).join();
		return employeeResponseModel;
	}
	
	@GetMapping
	public List<EmployeeResponseModel> getAllEmployees(){
		GetAllEmployeesQuery getAllBooksQuery = new GetAllEmployeesQuery();
		List<EmployeeResponseModel> list = 
				queryGateway.query(getAllBooksQuery, ResponseTypes.multipleInstancesOf(EmployeeResponseModel.class)).join();
		return list;
		
	}
	
}
