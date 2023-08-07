package com.employee.service.hht.company.query.projection;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.service.hht.company.command.data.Employee;
import com.employee.service.hht.company.command.data.EmployeeRepository;
import com.employee.service.hht.company.query.model.EmployeeResponseModel;
import com.employee.service.hht.company.query.queries.GetAllEmployeesQuery;
import com.employee.service.hht.company.query.queries.getEmployeeQuery;

@Component
public class EmployeeProjection {

	@Autowired
	private EmployeeRepository employeeRepository;

	@QueryHandler
	public EmployeeResponseModel handle(getEmployeeQuery getEmployeeQuery) {
		EmployeeResponseModel model = new EmployeeResponseModel();
		Employee employee = employeeRepository.getById(getEmployeeQuery.getEmployeeId());
		BeanUtils.copyProperties(employee, model);
		return model;
	}

	@QueryHandler
	public List<EmployeeResponseModel> handle(GetAllEmployeesQuery getAllEmployeesQuery) {
		List<EmployeeResponseModel> listEmployeeResponseModels = new ArrayList<>();
		List<Employee> list = employeeRepository.findAll();

		list.stream().forEach(item -> {
			EmployeeResponseModel model = new EmployeeResponseModel();
			BeanUtils.copyProperties(item, model);
			listEmployeeResponseModels.add(model);
		});
		return listEmployeeResponseModels;
	}
	
}
