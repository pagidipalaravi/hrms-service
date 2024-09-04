package com.host.domain.hrservice.service.spec;

import java.util.List;

import com.host.domain.hrservice.domain.Employees;
import com.host.domain.hrservice.view.EmployeesView;

public interface EmployeesService {

	Employees createEmployee(EmployeesView view);
	Employees updateEmployee(Employees employee);
	boolean deleteEmployeeById(Long id);
	List<Employees> getEmployees();
	Employees getEmployeeById(Long id);
	Employees getEmployeeByEmail(String email);
	List<Employees> getEmployees(int departmentId);
}
