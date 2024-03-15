package com.host.domain.hrservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.host.domain.hrservice.domain.Departments;

public interface DepartmentsRepository extends JpaRepository<Departments, Long> {

}
