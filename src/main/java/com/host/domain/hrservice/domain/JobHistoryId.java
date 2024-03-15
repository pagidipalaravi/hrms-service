package com.host.domain.hrservice.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class JobHistoryId implements Serializable {

	private static final long serialVersionUID = 6942400612555978992L;
	private Long employeeId;
	private Date startDate;

	public JobHistoryId() {
		
	}
	
	public JobHistoryId(Long employeeId, Date startDate) {
		this.employeeId = employeeId;
		this.startDate = startDate;
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


	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null || getClass() != object.getClass())
			return false;
		JobHistoryId jobHistoryId = (JobHistoryId) object;
		return employeeId.equals(jobHistoryId.employeeId) && startDate.equals(jobHistoryId.startDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId, startDate);
	}	
}
