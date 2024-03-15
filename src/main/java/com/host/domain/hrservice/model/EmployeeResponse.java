package com.host.domain.hrservice.model;

import java.io.Serializable;

public class EmployeeResponse implements Serializable {
	private ResponseHeader header;
	private EmployeeResponseBody employeeResponseBody;
	public ResponseHeader getHeader() {
		return header;
	}
	public void setHeader(ResponseHeader header) {
		this.header = header;
	}
	public EmployeeResponseBody getEmployeeResponseBody() {
		return employeeResponseBody;
	}
	public void setEmployeeResponseBody(EmployeeResponseBody employeeResponseBody) {
		this.employeeResponseBody = employeeResponseBody;
	}
	

}
