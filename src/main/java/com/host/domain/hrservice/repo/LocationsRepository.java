package com.host.domain.hrservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.host.domain.hrservice.domain.Locations;

public interface LocationsRepository extends JpaRepository<Locations, Long> {

}
