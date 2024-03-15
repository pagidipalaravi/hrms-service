package com.host.domain.hrservice.service.spec;

import java.util.List;

import com.host.domain.hrservice.domain.Regions;

public interface RegionsService {
	List getRegions();
	boolean createRegion(Regions region);
	boolean updateRegion(Regions region);
	Regions getRegionById(Long l);
	boolean deleteRegionById(Long l);

}
