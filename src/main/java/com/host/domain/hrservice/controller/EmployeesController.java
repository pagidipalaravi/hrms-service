package com.host.domain.hrservice.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.host.domain.hrservice.domain.Employees;
import com.host.domain.hrservice.response.ApiResponse;
import com.host.domain.hrservice.service.impl.EmployeesServiceImpl;
import com.host.domain.hrservice.util.JsonParserUtil;
import com.host.domain.hrservice.validate.EmployeeValidate;
import com.host.domain.hrservice.view.EmployeesView;

@CrossOrigin
@RestController
@RequestMapping("/employees")

public class EmployeesController {
	private static final Logger log = LogManager.getLogger(EmployeesController.class);
	@Autowired
	private EmployeesServiceImpl employeesServiceImpl;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")

	public String getEmployees() {
		log.trace("getEmployee method start");
		String response = "";
		ApiResponse apiResponse = null;
		try {
			List<Employees> empList = employeesServiceImpl.getEmployees();
			if (empList != null) {
				apiResponse = new ApiResponse(HttpStatus.OK.value(), "getting employees list ", empList);
				log.info("getting employee details");

			} else {
				apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), "Not getting employees ", "");
				log.error("employeeslist not found");
			}
			response = JsonParserUtil.toJson(apiResponse);

		} catch (Exception e) {
			e.printStackTrace();
		}
		log.trace("getEmployee method end");
		return response;
	}

	@RequestMapping(value = "/getEmployeeByDepartmentId/{id}", method = RequestMethod.GET, produces = "application/json")
	public String getEmployeeByDepartmentId(@PathVariable("id") int id) {
		log.trace("getEmployeeByDepartmentId method start");
		String response = "";
		List<Employees> empList = null;
		ApiResponse apiResponse = null;
		try {
			empList = employeesServiceImpl.getEmployees(id);
			if (empList != null) {
				apiResponse = new ApiResponse(HttpStatus.OK.value(), "getting employees list ", empList);
				log.info("getting Employeeslist");
			} else {
				apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), "Not getting employees ", "");
				log.error("employees not found");
			}
			response = JsonParserUtil.toJson(apiResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.trace("getEmployeeByDepartmentId method end");
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public String getEmployeeById(@PathVariable("id") int id) {
		log.trace("getEmployeeById method start");
		ApiResponse apiResponse = null;
		String response = "";
		try {
			Employees employee = employeesServiceImpl.getEmployeeById(Long.valueOf(id));
			if (employee != null) {
				apiResponse = new ApiResponse(HttpStatus.OK.value(), "getting employee by id", employee);
				log.info("getting Employee by id");

			} else {
				apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), "Not getting employee ", "");
				log.error("id is invalid");
			}

			response = JsonParserUtil.toJson(apiResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.trace("getEmployeeById method end");
		return response;
	}

	@RequestMapping(value = "/get/{email}", method = RequestMethod.GET, produces = "application/json")
	public String getEmployeeByEmail(@PathVariable("email") String email) {
		log.trace("getEmployeeByEmail method start");
		ApiResponse apiResponse = null;
		String response = "";
		try {
			Employees employee = employeesServiceImpl.getEmployeeByEmail(email);
			if (employee == null) {
				apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), "employee by this email does not exist",
						"");
				log.info("getting Employee by email");
			} else {
				apiResponse = new ApiResponse(HttpStatus.OK.value(), "Email is aready exist", "");
				log.error("email is invalid");
			}
			response = JsonParserUtil.toJson(apiResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.trace("getEmployeeByEmail method end");
		return response;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
	public String createEmployee(@RequestBody String request) {
		log.trace("createEmployee method start");
		EmployeesView employeesView = JsonParserUtil.fromJson(request, EmployeesView.class);
		ApiResponse apiResponse = null;
		String response = null;
		apiResponse = EmployeeValidate.validateEmployeeView(employeesView);
		if (apiResponse.getStatus() == 200) {
			Employees employee = employeesServiceImpl.createEmployee(employeesView);
			if (employee != null) {
				apiResponse = new ApiResponse(HttpStatus.OK.value(), "Employee created successfully", null);
				log.info("created successfully");
			} else {
				apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), "Employee not created", null);
				log.error("error in creating");
			}
		}
		response = JsonParserUtil.toJson(apiResponse);
		log.trace("createEmployee method end");
		return response;
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, produces = "application/json")
	public String updateEmployee(@RequestBody String request) {
		log.trace("updateEmployee method start");
		Employees employee = JsonParserUtil.fromJson(request, Employees.class);
		ApiResponse apiResponse = null;
		String response = null;
		try {
			Employees Employee = employeesServiceImpl.updateEmployee(employee);
			if (employee != null) {
				apiResponse = new ApiResponse(HttpStatus.OK.value(), "Employee successfully updated", Employee);
				log.info("updated successfully");
			} else {
				apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), "Employee not updated", null);
				log.error("error in updation");
			}
			response = JsonParserUtil.toJson(apiResponse);
		} catch (Exception e) {

		}
		log.trace("updateEmployee method end");
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public String deleteEmployee(@PathVariable("id") String id) {
		log.trace("deleteEmployee method start");
		boolean isDeleted = false;
		String response = "";
		ApiResponse apiResponse = null;
		try {
			isDeleted = employeesServiceImpl.deleteEmployeeById(Long.valueOf(id));
		} catch (Exception e) {
		}
		if (isDeleted) {
			apiResponse = new ApiResponse(HttpStatus.OK.value(), "employee with id =" + id + " deleted successfully",
					"");
			log.info("updated successfully");

		} else {
			// throw new RuntimeException("unable to delete employee with id ="+id);
			apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), "employee with id =" + id + " deoes not exist",
					"");
			log.error("error in deletion");
		}
		response = JsonParserUtil.toJson(apiResponse);
		log.trace("deleteEmployee method end");
		return response;
	}
}
