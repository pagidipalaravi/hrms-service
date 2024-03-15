package com.host.domain.hrservice.service.impl;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.host.domain.hrservice.domain.Employees;
import com.host.domain.hrservice.repo.EmployeesRepository;
import com.host.domain.hrservice.repo.JobHistoryRepository;
import com.host.domain.hrservice.repo.JobsRepository;
import com.host.domain.hrservice.service.spec.EmployeesService;
import com.host.domain.hrservice.view.EmployeesView;

@Service
public class EmployeesServiceImpl implements EmployeesService {

	@Autowired
	EmployeesRepository employeeRepository;
	@Autowired
	JobHistoryRepository jobhistoryRepository;
	@Autowired
	JobsRepository jobsRepository;
	
	@Override
	public Employees createEmployee(EmployeesView view) {
		Employees employee = null;
		String errorMessage = null;
		try {
			String dateStr = view.getHireDate();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
			Date dateUtil = simpleDateFormat.parse( dateStr );
			java.sql.Date dateSql = new java.sql.Date(dateUtil.getTime());
			Employees entity = new Employees();
			entity.setFirstName(view.getFirstName());
			entity.setLastName(view.getLastName());
			entity.setEmail(view.getEmail());
			entity.setHireDate(dateSql);
			entity.setJobId(view.getJobId());
			entity.setManagerId(view.getManagerId());
			entity.setDepartmentId(view.getDepartmentId());
			entity.setPhoneNumber(view.getPhoneNumber());
			entity.setSalary(view.getSalary());
			employee = employeeRepository.save(entity);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		if (employee == null) {
			throw new RuntimeException("unable to create employee : Error Message =" + errorMessage);
		}
		return employee;
	}

	@Override
	public Employees updateEmployee(Employees view) {
		Employees employee = null;
		String errorMessage = null;
		try {
			employee = employeeRepository.save(view);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		if (employee == null) {
			throw new RuntimeException("unable to update employee : Error Message =" + errorMessage);
		}
		else
		{
			System.out.println("updated employee");
		}
		return employee;
	}

	@Override
	public List<Employees> getEmployees() {
		List<Employees> empList = null;
		String errorMessage = null;
		try {
			empList = employeeRepository.findAll();
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		if (empList.equals(null)) {
			throw new RuntimeException("unable to get the employees : Error Message =" + errorMessage);
		}
		return empList;
	}

	@Override
	public List<Employees> getEmployees(int departmentId){
		List<Employees> empList = null;
		try {
			empList=employeeRepository.getEmployeesByDepartmentId(departmentId);
		}catch(Exception e) {
			
		}
		
		return empList;
	}
	
	@Override
	public Employees getEmployeeById(Long id) {
		Optional<Employees> optional = null;
		Employees employees = null;
		try {
			optional = employeeRepository.findById(id);
			if (optional.isPresent()) {
				employees = optional.get();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (employees.equals(null)) {
			throw new RuntimeException("unable to get the employee with id" + id);
		}
		return employees;
	}
	

	@Override
	public boolean deleteEmployeeById(Long id) {
		boolean isDeleted = false;
		try {
			// jobhistoryRepository.deleteJobhistoryById(id);
			System.out.println("jh");
			employeeRepository.deleteById(id);
			isDeleted = true;
		} catch (Exception e) {
			isDeleted = false;
			e.printStackTrace();
		}
		if (!isDeleted) {
			throw new RuntimeException("unable to delete employee with id =" + id);
		}
		return isDeleted;
	}

	public Employees getEmployeeByEmail(String email) {
		return employeeRepository.getEmployeeByEmail(email);
	}
	
	

}
