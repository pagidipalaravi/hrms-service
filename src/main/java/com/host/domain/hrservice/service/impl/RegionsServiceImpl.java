package com.host.domain.hrservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.host.domain.hrservice.domain.Regions;
import com.host.domain.hrservice.repo.RegionsRepository;
import com.host.domain.hrservice.service.spec.RegionsService;

@Service
public class RegionsServiceImpl implements RegionsService {

	@Autowired
	RegionsRepository regionsRepository;

	@Override
	public List<Regions> getRegions() {
		List<Regions> regionsList = null;
		try {
			regionsList = regionsRepository.findAll();
		} catch (Exception e) {
			throw new RuntimeException("Unable to get Regions");
		}
		return regionsList;

	}

	@Override
	public boolean createRegion(Regions region) {
		try {
			regionsRepository.save(region);
		} catch (Exception e) {
			throw new RuntimeException("Unable to create Region");
		}
		return true;
	}

	@Override
	public boolean updateRegion(Regions region) {
		try {
			regionsRepository.save(region);
		} catch (Exception e) {
			throw new RuntimeException("Unable to update Region");
		}
		return true;
	}

	@Override
	public Regions getRegionById(Long regionId) {
		Optional<Regions> optional = null;
		Regions regions = null;
		try {
			optional = regionsRepository.findById(regionId);
			if (optional.isPresent()) {
				regions = optional.get();
			} else {
				throw new RuntimeException("Unable to get Region By Id");
			}
		} catch (Exception e) {

		}
		return regions;
	}

	@Override
	public boolean deleteRegionById(Long regionId) {
		try {
			regionsRepository.deleteById(regionId);
		} catch (Exception e) {
			throw new RuntimeException("unable to delete Region By Id");
		}
		return true;
	}

}
