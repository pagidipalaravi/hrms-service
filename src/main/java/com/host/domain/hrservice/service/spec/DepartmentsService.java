package com.host.domain.hrservice.service.spec;

import java.util.List;
import java.util.Optional;

import com.host.domain.hrservice.domain.Departments;
import com.host.domain.hrservice.response.ApiResponse;

public interface DepartmentsService {

	Departments createDepartment(Departments department);
	List getDepartments();
	Departments updateDepartment(Departments department);
	boolean deleteDepartmentById(Long l);
	Departments getDepartmentById(Long l);
	
	
}
