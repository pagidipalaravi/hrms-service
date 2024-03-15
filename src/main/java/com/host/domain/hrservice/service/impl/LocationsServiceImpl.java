package com.host.domain.hrservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.host.domain.hrservice.domain.Locations;
import com.host.domain.hrservice.repo.LocationsRepository;
import com.host.domain.hrservice.service.spec.LocationsService;

@Service

public class LocationsServiceImpl implements LocationsService {
	
	@Autowired
	LocationsRepository locationsRepository;
	
	LocationsService locationService;
	@Override
	public List<Locations> getLocations() {
		List<Locations> locationList = null;
		String errorMessage = null;
		try {
			locationList = locationsRepository.findAll();
			System.out.println("hello");
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		if (locationList.equals(null)) {
			throw new RuntimeException("unable to get the locations : Error Message =" + errorMessage);
		}
		return locationList;
	}
}
