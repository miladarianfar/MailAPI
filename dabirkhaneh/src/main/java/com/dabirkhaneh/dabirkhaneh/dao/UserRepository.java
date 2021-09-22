package com.dabirkhaneh.dabirkhaneh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dabirkhaneh.dabirkhaneh.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
