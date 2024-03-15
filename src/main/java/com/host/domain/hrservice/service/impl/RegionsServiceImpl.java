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
			List<Regions> regList=null;
			try {
				regList = regionsRepository.findAll();
				System.out.println("size = "+regList.size());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return regList;
		
	}

	@Override
	public boolean createRegion(Regions theRegion) {
			Regions region=theRegion;
			try {
				regionsRepository.save(region);	
				}catch(Exception e) {
					e.printStackTrace();
				}
			return true;
	}

	@Override
	public boolean updateRegion(Regions theRegion) {
		Regions region=theRegion;
		try {
			regionsRepository.save(region);	
			}catch(Exception e) {
				e.printStackTrace();
			}
		return true;
	}
	@Override
	public Regions getRegionById(Long l) {
		Optional<Regions> optional=null;
		Regions regions = null;
		Long l2 = new Long(l);
		try {
			optional=regionsRepository.findById(l2);
			if(optional.isPresent()) {
				regions = optional.get();
				//return departments;
			}
			else {
				throw new RuntimeException("Did not find region id"+l);
			}
		}catch(Exception e) {
			
		}
	return regions;
	}

	@Override
	public boolean deleteRegionById(Long l) {
		Long l2=new Long(l);
		try {
			regionsRepository.deleteById(l2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}


}
