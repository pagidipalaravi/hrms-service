package com.host.domain.hrservice.view;

import java.io.Serializable;

public class DepartmentsView implements Serializable {

	private static final long serialVersionUID = 8838792496575404687L;

	private Long departmentId;
	private String departmentName;
	private Long managerId;
	private Long locationId;
	

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

}
