package com.host.domain.hrservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.host.domain.hrservice.domain.Countries;
import com.host.domain.hrservice.repo.CountriesRepository;
import com.host.domain.hrservice.service.spec.CountriesService;
@Service
public class CountriesServiceImpl implements CountriesService {

	@Autowired
	CountriesRepository countriesRepository;
	@Override
	public int createCountry(Countries theCountry) {
		Countries country=theCountry;
		try {
			countriesRepository.save(country);	
			}catch(Exception e) {
				e.printStackTrace();
			}
		return 0;
	}

	@Override
	public List getCountries() {
	List<Countries> CountList=null;
	try {
		CountList=countriesRepository.findAll();	
		System.out.println("size="+CountList.size());
		}catch(Exception e) {
			e.printStackTrace();
		}
	return CountList;
	}

	@Override
	public boolean updateCountry(Countries theCountry) {
		Countries country=theCountry;
		try {
			countriesRepository.save(country);	
			}catch(Exception e) {
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean deleteCountryById(String s) {
		try {
			countriesRepository.deleteById(s);;	
			}catch(Exception e) {
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public Countries getCountryById(String s) {
		Optional<Countries> optional=null;
		Countries countries = null;
		String s1 = new String();
		try {
			optional=countriesRepository.findById(s);
			if(optional.isPresent()) {
				countries = optional.get();
				//return departments;
			}
			else {
				throw new RuntimeException("Did not find country id"+s1);
			}
		}catch(Exception e) {
			
		}
	return countries;
	}

}
