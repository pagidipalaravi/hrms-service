package com.host.domain.hrservice.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LOCATIONS")

public class Locations implements Serializable {

	
	private static final long serialVersionUID = -6383049141167660621L;
	
	@Id
	@Column(name = "LOCATION_ID")
	
	private Long locationId;
	
	@Column(name = "STREET_ADDRESS")
	private String streetAddress;
	
	@Column(name = "POSTAL_CODE")
	private String postalCode;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE_PROVINCE")
	private String stateProvince;
	
	@Column(name = "COUNTRY_ID")
	private String countryId;
	
	
	

}
