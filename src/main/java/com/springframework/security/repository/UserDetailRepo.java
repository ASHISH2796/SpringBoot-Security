package com.springframework.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springframework.security.model.UserDetail;

public interface UserDetailRepo extends JpaRepository<UserDetail, Integer>{
	
	Optional<UserDetail> findByUserName(String userName);
}
