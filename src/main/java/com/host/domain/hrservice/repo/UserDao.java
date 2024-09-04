package com.host.domain.hrservice.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.host.domain.hrservice.domain.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	User findByUsername(String username);
}
