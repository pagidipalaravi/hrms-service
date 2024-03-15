package com.host.domain.hrservice.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="countries")

public class Countries implements Serializable {

	private static final long serialVersionUID = 7334626336619741343L;

	@Id
	@Column(name="country_id")
	private String countryId;
	
	@Column(name="country_name")
	private String countryName;
	
	@Column(name="region_id")
	private Long regionId;
}
