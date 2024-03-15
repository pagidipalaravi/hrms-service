package com.host.domain.hrservice.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="departments")

public class Departments implements Serializable {
	
	private static final long serialVersionUID = -8574460800041343526L;

	@Id
	@Column(name="department_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEPARTMENTS_SEQ")
    @SequenceGenerator(sequenceName = "DEPARTMENTS_SEQ", allocationSize = 1, name = "DEPARTMENTS_SEQ")
	private Long departmentId;
	
	@Column(name="department_name")
	private String departmentName;
	
	@Column(name="manager_id")
	private Long managerId;
	
	@Column(name="location_id")
	private Long locationId;

	public Long getDepartmentId() {
		return departmentId;
	}
//	@OneToOne(mappedBy = "employeeId", cascade = CascadeType.ALL)
//	@JoinColumn(name="manager_id")
//	private Employees employe;

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDeprtmentName() {
		return departmentName;
	}

	public void setDeprtmentName(String departmentName) {
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

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
//
//	public Set<Employees> getEmployeesList() {
//		return employeesList;
//	}
//
//	public void setEmployeesList(Set<Employees> employeesList) {
//		this.employeesList = employeesList;
//	}
	
}
