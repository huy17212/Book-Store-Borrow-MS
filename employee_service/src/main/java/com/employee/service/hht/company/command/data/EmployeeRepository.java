package com.employee.service.hht.company.command.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeRepository extends JpaRepository<Employee, String>  {

}
