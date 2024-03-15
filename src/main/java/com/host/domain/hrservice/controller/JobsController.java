package com.host.domain.hrservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.host.domain.hrservice.domain.Jobs;
import com.host.domain.hrservice.response.ApiResponse;
import com.host.domain.hrservice.service.impl.JobsServiceImpl;
import com.host.domain.hrservice.util.JsonParserUtil;

@CrossOrigin
@RestController
@RequestMapping("/jobs")
public class JobsController {

	@Autowired
	private JobsServiceImpl jobsService;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")

	public String getJobs() {
		System.out.println("getJobs");
		String response = "";
		ApiResponse apiResponse = null;
		try {
			List<Jobs> empList = jobsService.getJobs();
			if (empList != null) {
				apiResponse = new ApiResponse(HttpStatus.OK.value(), "jobs list with size:" + empList.size(), empList);
			} else {
				apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(),
						"jobs list not found size:" + empList.size(), empList);
			}
			response = JsonParserUtil.toJson(apiResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
