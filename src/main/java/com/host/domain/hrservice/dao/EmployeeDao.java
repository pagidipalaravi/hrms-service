package com.host.domain.hrservice.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.host.domain.hrservice.domain.Employees;
import com.host.domain.hrservice.model.EmployeeRequest;
import com.host.domain.hrservice.repo.EmployeesRepository;

public class EmployeeDao {
	@Autowired
	private EmployeesRepository employeeRepository;
//	public String getEmployees(EmployeeRequest request) {
//		Iterable<Employees> employees= employeeRepository.findAll();
//		return null;
//	}
	

}
