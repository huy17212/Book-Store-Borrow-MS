package com.employee.service.hht.company.command.controller;

import java.util.UUID;

import javax.xml.transform.Source;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.channel.NullChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.service.hht.company.command.command.CreateEmployeeCommand;
import com.employee.service.hht.company.command.command.DeleteEmployeeCommand;
import com.employee.service.hht.company.command.command.UpdateEmployeeCommand;
import com.employee.service.hht.company.command.model.EmployeeRequestModel;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1/employees")
@EnableBinding(Source.class)
public class EmployeeCommandController {
	
	@Autowired
	private MessageChannel output;
	
	@Autowired
	private CommandGateway commandGateway;

	@PostMapping
	public String addEmployee(@RequestBody EmployeeRequestModel employeeRequestModel) {

		CreateEmployeeCommand command = new CreateEmployeeCommand(UUID.randomUUID().toString(),
				employeeRequestModel.getFirstName(), employeeRequestModel.getLastName(), employeeRequestModel.getKin(),
				employeeRequestModel.getIsDisciplined());
		commandGateway.sendAndWait(command);
		return "employee added successful";
	}

	@PutMapping
	public String updateEmployee(@RequestBody EmployeeRequestModel model) {
		UpdateEmployeeCommand updateEmployeeCommand = new UpdateEmployeeCommand(model.getEmployeeId(),
				model.getFirstName(), model.getLastName(), model.getKin(), model.getIsDisciplined());
		commandGateway.sendAndWait(updateEmployeeCommand);
		return "employee updated successful";
	}

	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable String id) {
		DeleteEmployeeCommand command = new DeleteEmployeeCommand(id);
		commandGateway.sendAndWait(command);
		return "employee deleted successful";
	}
	
	@PostMapping("/sendMessage")
	public void  SendMessage(@RequestBody String message) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(message);
			output.send(MessageBuilder.withPayload(json).build());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
