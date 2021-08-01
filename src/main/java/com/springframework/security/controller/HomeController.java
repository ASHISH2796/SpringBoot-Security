package com.springframework.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String getHomePage() {
		return "<h1>Welcome</h1>";	
	}

}
