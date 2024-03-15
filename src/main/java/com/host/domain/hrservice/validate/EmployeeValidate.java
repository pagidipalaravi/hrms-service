package com.host.domain.hrservice.validate;

import org.springframework.http.HttpStatus;

import com.host.domain.hrservice.response.ApiResponse;
import com.host.domain.hrservice.view.EmployeesView;

public class EmployeeValidate extends Validate {
	public static ApiResponse validateEmployeeView(EmployeesView employeesView) {
		ApiResponse apiResponse = null;
		if (isNullOrEmpty(employeesView.getFirstName())) {
			apiResponse = new ApiResponse(HttpStatus.BAD_REQUEST.value(), "First Name can't be null or empty", null);
			System.out.println("if" + employeesView.getFirstName());
		} else if (isNullOrEmpty(employeesView.getLastName())) {
			apiResponse = new ApiResponse(HttpStatus.BAD_REQUEST.value(), "Last Name can't be null or empty", null);
			System.out.println("if" + employeesView.getLastName());
		} else if (isNullOrEmpty(employeesView.getEmail())) {
			apiResponse = new ApiResponse(HttpStatus.BAD_REQUEST.value(), "Email can't be null or empty", null);
			System.out.println("if" + employeesView.getEmail());
		} else if (isNullOrEmpty(employeesView.getPhoneNumber())) {
			apiResponse = new ApiResponse(HttpStatus.BAD_REQUEST.value(), "Phonenumber can't be null or empty", null);
			System.out.println("if" + employeesView.getPhoneNumber());
		} else if (isNullOrEmpty(employeesView.getHireDate())) {
			apiResponse = new ApiResponse(HttpStatus.BAD_REQUEST.value(), "Hiredate can't be null or empty", null);
			System.out.println("if" + employeesView.getHireDate());
		} else if (isNullOrEmptyObject(Double.toString(employeesView.getSalary()))) {
			apiResponse = new ApiResponse(HttpStatus.BAD_REQUEST.value(), "Salary can't be null or empty", null);
			System.out.println("if" + employeesView.getSalary());
		} else if (isNullOrEmptyObject(employeesView.getJobId())) {
			apiResponse = new ApiResponse(HttpStatus.BAD_REQUEST.value(), "Jobname can't be null or empty", null);
			System.out.println("if" + employeesView.getJobId());
		} else if (isNullOrEmptyObject(employeesView.getDepartmentId())) {
			apiResponse = new ApiResponse(HttpStatus.BAD_REQUEST.value(), "Department Name can't be null or empty", null);
			System.out.println("if" + employeesView.getDepartmentId());
		} else if (isNullOrEmptyObject(employeesView.getManagerId())) {
			apiResponse = new ApiResponse(HttpStatus.BAD_REQUEST.value(), "Manager Name can't be null or empty", null);
			System.out.println("if" + employeesView.getManagerId());
		} else {
			System.out.println("validateEmployeeView else block");
			apiResponse = new ApiResponse(HttpStatus.OK.value(), "validation success", "SUCCESS");
		}
		return apiResponse;
	}
}
