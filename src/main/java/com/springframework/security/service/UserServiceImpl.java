package com.springframework.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springframework.security.model.UserDetail;
import com.springframework.security.model.dto.CustomUserDetail;
import com.springframework.security.repository.UserDetailRepo;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailRepo userDetailRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserDetail> user =userDetailRepo.findByUserName(username);
		user.orElseThrow(()->new UsernameNotFoundException("Invalid Username."));
		return new CustomUserDetail(user.get());
	}

}
