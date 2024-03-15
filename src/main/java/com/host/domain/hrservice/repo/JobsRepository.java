package com.host.domain.hrservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.host.domain.hrservice.domain.Jobs;

public interface JobsRepository extends JpaRepository<Jobs,String> {
}
