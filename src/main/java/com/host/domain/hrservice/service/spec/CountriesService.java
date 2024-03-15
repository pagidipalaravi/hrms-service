package com.host.domain.hrservice.service.spec;

import java.util.List;

import com.host.domain.hrservice.domain.Countries;

public interface CountriesService {

	int createCountry(Countries country);
	List getCountries();
	boolean updateCountry(Countries country);
	Countries getCountryById(String s);
	boolean deleteCountryById(String s);
}
