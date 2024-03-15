package com.host.domain.hrservice.model;

import java.io.Serializable;

public class EmployeeRequest implements Serializable {
	private RequestHeader header;
	private EmployeeRequestBody body;
	public RequestHeader getHeader() {
		return header;
	}
	public void setHeader(RequestHeader header) {
		this.header = header;
	}
	public EmployeeRequestBody getBody() {
		return body;
	}
	public void setBody(EmployeeRequestBody body) {
		this.body = body;
	}
	

}
