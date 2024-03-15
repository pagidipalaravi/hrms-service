package com.host.domain.hrservice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.host.domain.hrservice.domain.Employees;

public class EmployeeResponseBody {
	private List<String> displayColumns = new ArrayList<> ();
	private List<String> columns = new ArrayList<>();
	private List<Employees> employeesList = new ArrayList<Employees>();
	public List<String> getDisplayColumns() {
		return displayColumns;
	}
	public void setDisplayColumns(List<String> displayColumns) {
		this.displayColumns = displayColumns;
	}
	public List<String> getColumns() {
		return columns;
	}
	public void setColumns(List<String> columns) {
		this.columns = columns;
	}
	public List<Employees> getEmployeesList() {
		return employeesList;
	}
	public void setEmployeesList(List<Employees> employeesList) {
		this.employeesList = employeesList;
	}

}
