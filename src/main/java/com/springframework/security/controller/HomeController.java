package com.springframework.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.security.config.util.JWTUtil;
import com.springframework.security.model.dto.AuthenticationRequest;
import com.springframework.security.model.dto.AuthenticationResponse;

@RestController
public class HomeController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JWTUtil jwtUtil;
	
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

	@PostMapping("/authenticate")
	public ResponseEntity<?>  authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		String jwt=null;
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUser(), authenticationRequest.getPassword()));
			final UserDetails user = userDetailsService.loadUserByUsername(authenticationRequest.getUser());
			 jwt= jwtUtil.generateToken(user);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect Username or Password", e);
		}
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
