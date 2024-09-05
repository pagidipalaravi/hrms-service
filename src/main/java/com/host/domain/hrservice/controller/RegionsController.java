package com.host.domain.hrservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.host.domain.hrservice.domain.Regions;
import com.host.domain.hrservice.service.impl.RegionsServiceImpl;
import com.host.domain.hrservice.util.JsonParserUtil;

@CrossOrigin
@RestController
@RequestMapping("/regions")

public class RegionsController {

	@Autowired
	private RegionsServiceImpl regionsServiceImpl;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public String getRegions() {
		String response = null;
		try {
			List<Regions> regList = regionsServiceImpl.getRegions();
			response = JsonParserUtil.toJson(regList);
		} catch (Exception e) {
			throw new RuntimeException("Did not find region id " + e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
	public String creatRegion(@RequestBody String request) {
		Regions region = JsonParserUtil.fromJson(request, Regions.class);
		String response = "";
		try {
			regionsServiceImpl.createRegion(region);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, produces = "application/json")
	public String updateRegion(@RequestBody String request) {
		Regions region = JsonParserUtil.fromJson(request, Regions.class);
		String response = null;
		try {
			regionsServiceImpl.updateRegion(region);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public String getRegionById(@PathVariable("id") String id) {
		Long l = Long.valueOf(id);
		String response = null;
		Regions region = null;
		try {
			region = regionsServiceImpl.getRegionById(l);
			response = JsonParserUtil.toJson(region);
		} catch (Exception e) {
			throw new RuntimeException("Did not find region id " + e.getMessage());
		}
		if (region != null) {
			return response;
		} else {
			throw new RuntimeException("Did not find region id " + id);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public String deleteRegionById(@PathVariable("id") String id) {
		Long l = Long.valueOf(id);
		String response = "";
		try {
			regionsServiceImpl.deleteRegionById(l);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
