package com.host.domain.hrservice.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
public class Regions implements Serializable {
	private static final long serialVersionUID = 6257325467519786640L;
	@Id
	@Column(name = "region_id")
	private Long regionId;
	@Column(name = "region_name")
	private String regionName;
}
