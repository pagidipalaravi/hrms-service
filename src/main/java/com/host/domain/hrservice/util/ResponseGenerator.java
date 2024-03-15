package com.host.domain.hrservice.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.host.domain.hrservice.domain.Employees;
import com.host.domain.hrservice.model.EmployeeRequest;
import com.host.domain.hrservice.model.EmployeeResponse;
import com.host.domain.hrservice.model.EmployeeResponseBody;
import com.host.domain.hrservice.model.RequestHeader;
import com.host.domain.hrservice.model.ResponseHeader;
@Component
public class ResponseGenerator {
	
	public EmployeeResponse generateResponse(EmployeeRequest request, List<Employees> employeesList) {
		EmployeeResponse employeeResponse = new EmployeeResponse(); 
		ResponseHeader responseHeader = buildResponseHeader(request.getHeader());
		EmployeeResponseBody employeeResponseBody  = new EmployeeResponseBody();
		employeeResponseBody.setEmployeesList(employeesList);
		employeeResponse.setHeader(responseHeader);
		employeeResponse.setEmployeeResponseBody(employeeResponseBody);
		return employeeResponse;
	}
	private ResponseHeader buildResponseHeader(RequestHeader reqHeader) {
		ResponseHeader respHeader = new ResponseHeader(reqHeader.getRequestId(), reqHeader.getUserId(),
				reqHeader.getTimeStamp(), reqHeader.getCorelationId());
		respHeader.setStatusCode("000");
		respHeader.setStatusMsg("Success");
		return respHeader;
	}
}
