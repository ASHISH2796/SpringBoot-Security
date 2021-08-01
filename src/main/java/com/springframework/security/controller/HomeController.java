package com.springframework.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String getHomePage() {
		return "<h1>Welcome</h1>";	
	}
	
	@RequestMapping("/user")
	public String getUserPage() {
		return "<h1>Welcome User</h1>";	
	}
	
	@RequestMapping("/admin")
	public String getAdminPage() {
		return "<h1>Welcome Admin</h1>";	
	}

}
