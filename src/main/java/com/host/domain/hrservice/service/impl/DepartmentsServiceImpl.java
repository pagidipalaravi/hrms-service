package com.host.domain.hrservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.host.domain.hrservice.domain.Departments;
import com.host.domain.hrservice.repo.DepartmentsRepository;
import com.host.domain.hrservice.service.spec.DepartmentsService;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {

	@Autowired
	DepartmentsRepository departmentsRepository;

	@Override
	public Departments createDepartment(Departments theDepartment) {
		Departments department = null;
		try {
			department = departmentsRepository.save(theDepartment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return department;
	}

	@Override
	public List<Departments> getDepartments() {
		List<Departments> deptList = null;
		try {
			deptList = departmentsRepository.findAll();
			System.out.println("getdepartments");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return deptList;
	}

	@Override
	public Departments getDepartmentById(Long id) {
		Optional<Departments> optional = null;
		Departments departments = null;
		//Long l2 = new Long(l);
		try {
			optional = departmentsRepository.findById(id);
			if (optional.isPresent()) {
				departments = optional.get();
			}
		} catch (Exception e) {

		}
		if (departments.equals(null)) {
			throw new RuntimeException("unable to get the department with id" + id);
		}
		return departments;
	}

	@Override
	public Departments updateDepartment(Departments theDepartment) {
		Departments department = null;
		String errorMessage=null;
		
		try {
			department=departmentsRepository.save(theDepartment);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		if (department == null) {
			throw new RuntimeException("unable to update department : Error Message =" + errorMessage);
		}
		return department;
	}

	@Override
	public boolean deleteDepartmentById(Long id) {
		//Long l2 = new Long(l);
		boolean isDeleted = false;
		try {
			departmentsRepository.deleteById(id);
			isDeleted=true;
		} catch (Exception e) {
			isDeleted = false;
			e.printStackTrace();
		}
		if (!isDeleted) {
			throw new RuntimeException("unable to delete department with id =" + id);
		}
		return isDeleted;
	}

}
