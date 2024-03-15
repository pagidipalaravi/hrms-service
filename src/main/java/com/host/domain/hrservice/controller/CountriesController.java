package com.host.domain.hrservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.host.domain.hrservice.domain.Countries;
import com.host.domain.hrservice.response.ApiResponse;
import com.host.domain.hrservice.service.impl.CountriesServiceImpl;
import com.host.domain.hrservice.util.JsonParserUtil;

@CrossOrigin
@RestController
@RequestMapping("/countries")

public class CountriesController {
	
	@Autowired
	private CountriesServiceImpl countriesServiceImpl;
	
	@RequestMapping(value="/create",method=RequestMethod.POST,produces="application/json")
	public String createCountry(@RequestBody String request) {
		Countries country = JsonParserUtil.fromJson(request, Countries.class);
		String response = null;
		try {
			countriesServiceImpl.createCountry(country);
		}catch(Exception e){
			throw new RuntimeException("Did not find country id " +e.getMessage());
		}
		return response;
	}
	@RequestMapping(value="/update",method=RequestMethod.PUT,produces="application/json")
	public String updateCountry(@RequestBody String request) {
		Countries country = JsonParserUtil.fromJson(request, Countries.class);
		String response = "";
		try {
			countriesServiceImpl.updateCountry(country);
		}catch(Exception e){
		e.printStackTrace();	
		}
		return response;
	}
	@RequestMapping(value="/",method=RequestMethod.GET,produces="application/json")
	public String getCountries() {
		int size=0;
		String response = "";
		ApiResponse apiResponse=null;
		try {
		List<Countries> countList= countriesServiceImpl.getCountries();
		apiResponse = new ApiResponse(HttpStatus.OK.value(), "getting countries list ", countList);
		response = JsonParserUtil.toJson(apiResponse);
		size = countList.size();
		}catch(Exception e) {
			e.printStackTrace();	
		}
		return response;
	}
	@RequestMapping(value="/{id}", method=RequestMethod.GET,produces="application/json")
	public String getCountryById(@PathVariable("id") String id) {
		String response = null;
		Countries country = null;
		System.out.println("id = "+id);
		try {
			country = countriesServiceImpl.getCountryById(id);
			response = JsonParserUtil.toJson(country);
		}catch(Exception e) {
			e.printStackTrace();	
		}
		if(country!=null) {
			return response;
			//return departments;
		}
		else {
			throw new RuntimeException("Did not find country id "+id);
		}
	}
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE, produces="application/json")
	public String deleteCountryById(@PathVariable("id") String id) {
		String response = "";
		System.out.println("id = "+id);
		try {
			countriesServiceImpl.deleteCountryById(id);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
