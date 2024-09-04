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

import com.host.domain.hrservice.domain.Departments;
import com.host.domain.hrservice.response.ApiResponse;
import com.host.domain.hrservice.service.impl.DepartmentsServiceImpl;
import com.host.domain.hrservice.util.JsonParserUtil;

@CrossOrigin
@RestController
@RequestMapping("/departments")

public class DepartmentsController {
	private static final Logger log = LogManager.getLogger(DepartmentsController.class);
	@Autowired
	private DepartmentsServiceImpl departmentsServiceImpl;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public String getDepartments() {
		log.trace("getDepartments method start");
		ApiResponse apiResponse = null;
		String response = "";
		try {
			List<Departments> deptList = departmentsServiceImpl.getDepartments();
			if (deptList != null) {
				apiResponse = new ApiResponse(HttpStatus.OK.value(), "getting departments list", deptList);
				log.info("getting departmnts list");
			} else {
				apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), "failure", "");
				log.error("error in getting departmets list");
			}
			response = JsonParserUtil.toJson(apiResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.trace("getDepartments method end");
		return response;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
	public String createDepartment(@RequestBody String request) {
		log.trace("createDepartment method start");
		Departments department = JsonParserUtil.fromJson(request, Departments.class);
		String response = "";
		ApiResponse apiResponse = null;

		try {
			department = departmentsServiceImpl.createDepartment(department);
			if (department != null) {
				apiResponse = new ApiResponse(HttpStatus.OK.value(),
						"Department successfully created with Department id =" + department.getDepartmentId(), null);
				log.info("created department");
			} else {
				apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), "department not created", null);
				log.error("error in creating department");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response = JsonParserUtil.toJson(apiResponse);
		log.trace("createDepartment method end");
		return response;
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, produces = "application/json")
	public String updateDepartment(@RequestBody String request) {
		log.trace("updateDepartment method start");
		Departments department = JsonParserUtil.fromJson(request, Departments.class);
		String response = "";
		ApiResponse apiResponse = null;
		try {
			Departments Department = departmentsServiceImpl.updateDepartment(department);
			if (Department != null) {
				apiResponse = new ApiResponse(HttpStatus.OK.value(), "Department successfully updated", Department);
				log.info("updated successfully");
			} else {
				apiResponse = new ApiResponse(HttpStatus.OK.value(), "Department not updated", null);
				log.error("error in updating department");
			}
			response = JsonParserUtil.toJson(apiResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.trace("updateDepartment method end");
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public String getDepartmentById(@PathVariable("id") String id) {
		log.trace("getDepartmentById method start");
		Long l = Long.valueOf(id);
		ApiResponse apiResponse = null;
		String response = "";
		try {
			Departments department = departmentsServiceImpl.getDepartmentById(l);
			if (department != null) {
				apiResponse = new ApiResponse(HttpStatus.OK.value(), "getting department by id", department);
				log.info("getting department by id");
			} else {
				apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), "error in getting employee", "");
				log.error("error in getting department");
			}
			response = JsonParserUtil.toJson(apiResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.trace("getDepartmentById method end");
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public String deleteDepartment(@PathVariable("id") String id) {
		log.trace("deleteDepartment method start");
		// System.out.println("delete method start");
		Long l = Long.valueOf(id);
		boolean isDeleted = false;
		ApiResponse apiResponse = null;
		String response = "";
		try {
			isDeleted = departmentsServiceImpl.deleteDepartmentById(l);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (isDeleted) {
			apiResponse = new ApiResponse(HttpStatus.OK.value(), "department with id =" + id + " deleted successfully",
					"");
			log.info("deleted department successfully");
		} else {
			apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), "department with id =" + id + " deoes not exist",
					"");
			log.error("error in deleting department");
		}
		response = JsonParserUtil.toJson(apiResponse);
		log.trace("deleteDepartment method end");
		return response;
	}
}
