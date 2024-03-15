package com.host.domain.hrservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.host.domain.hrservice.domain.Jobs;
import com.host.domain.hrservice.repo.JobsRepository;
import com.host.domain.hrservice.service.spec.JobsService;

@Service
public class JobsServiceImpl implements JobsService {

	@Autowired
	JobsRepository jobsRepository;
	@Override
	public List<Jobs> getJobs() {
		List<Jobs> jobsList = null;
		String errorMessage = null;
		try {
			jobsList = jobsRepository.findAll();
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		if (jobsList.equals(null)) {
			throw new RuntimeException("unable to get the jobs : Error Message =" + errorMessage);
		}
		return jobsList;
	}

}
