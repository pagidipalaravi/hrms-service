package com.host.domain.hrservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.host.domain.hrservice.domain.Locations;
import com.host.domain.hrservice.response.ApiResponse;
import com.host.domain.hrservice.service.impl.LocationsServiceImpl;
import com.host.domain.hrservice.util.JsonParserUtil;

@CrossOrigin
@RestController
@RequestMapping("/locations")

public class LocationsController {
	
	@Autowired
	private LocationsServiceImpl locationsServiceImpl;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")

	public String getLocations() {
		System.out.println("getLocations");
		String response = "";
		ApiResponse apiResponse = null;
		try {
			List<Locations> LocationList = locationsServiceImpl.getLocations();
			apiResponse = new ApiResponse(HttpStatus.OK.value(), "getting locationsList ", LocationList);
			response = JsonParserUtil.toJson(apiResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}


}
