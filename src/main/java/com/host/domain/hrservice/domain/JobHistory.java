package com.host.domain.hrservice.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(JobHistoryId.class)
@Table(name = "job_history")

public class JobHistory implements Serializable {

	private static final long serialVersionUID = -1988586771053901655L;
	@Id
	@Column(name = "EMPLOYEE_ID")
	private Long employeeId;

	@Id
	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "JOB_ID")
	private String jobId;

	@Column(name = "DEPARTMENT_ID")
	private Long departmentId;

	public JobHistory() {

	}

	public JobHistory(Long employeeId, Date startDate, Date endDate, String jobId, Long departmentId) {
		this.employeeId = employeeId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.jobId = jobId;
		this.departmentId = departmentId;

	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
}
