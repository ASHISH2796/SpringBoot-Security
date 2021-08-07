package com.springframework.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.springframework.security.model.UserDetail;
import com.springframework.security.repository.UserDetailRepo;

/**
 * @author Ashish Gupta
 * will insert 2 rows in user table
 */
@Component
public class UserDataBootStrap implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserDetailRepo userDetailRepo;
	
	@Override
		public void onApplicationEvent(ContextRefreshedEvent event) {
			System.out.println("BootStraping data....");
			System.out.println("User inserted : "+ userDetailRepo.save(new UserDetail("user", "user", "ROLE_USER", true)));
			System.out.println("Admin inserted : "+ userDetailRepo.save(new UserDetail("admin", "admin", "ROLE_ADMIN", true)));
			System.out.println("Admin inserted : "+ userDetailRepo.save(new UserDetail("dummy", "dummy", "USER", true)));
		}

	}
