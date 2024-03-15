package com.host.domain.hrservice.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jobs")

public class Jobs implements Serializable {

	private static final long serialVersionUID = -848670504936563208L;

	@Id
	@Column(name="JOB_ID")
	private String jobId;
	
	@Column(name="JOB_TITLE")
	private String jobTitle;
	
	@Column(name="MIN_SALARY")
	private String minSalary;
	
	@Column(name="MAX_SALARY")
	private String maxSalary;
}
