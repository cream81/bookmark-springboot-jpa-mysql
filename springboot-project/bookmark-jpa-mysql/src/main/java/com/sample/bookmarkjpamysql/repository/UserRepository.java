package com.sample.bookmarkjpamysql.repository;

import org.springframework.data.repository.CrudRepository;

import com.sample.bookmarkjpamysql.model.dto.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}