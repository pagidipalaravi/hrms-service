package com.host.domain.hrservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.host.domain.hrservice.domain.Countries;

public interface CountriesRepository extends JpaRepository<Countries, String> {

}
