package com.host.domain.hrservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.host.domain.hrservice.domain.JobHistory;
import com.host.domain.hrservice.domain.JobHistoryId;

public interface JobHistoryRepository extends JpaRepository<JobHistory, Long> {

	@Query("delete from JobHistory where employeeId =: employeeId")
	void deleteJobhistoryById(@Param("employeeId") Long employeeId);

	@Query("delete from JobHistory where JobHistoryId =: jobHistoryId")
	void deleteJobhistory(@Param("jobHistoryId") Long jobHistoryId);
}
