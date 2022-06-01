package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.JWTRequest;
import com.cg.model.JWTResponse;
import com.cg.service.UserService;
import com.cg.utility.JWTUtility;

@RestController
public class JWTController {

	@Autowired
	private JWTUtility jwtUtility;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String response() {
		return "Sucessfull Login";
	}
	
	@PostMapping("/auth")
	public JWTResponse authenticate(@RequestBody JWTRequest jwtRequest) throws Exception{
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						jwtRequest.getUsername(), jwtRequest.getPassword()));
		}
		catch(BadCredentialsException e) {
			throw new Exception("Invalid_Credentials",e);
		}
		final UserDetails userDetails
			= userService.loadUserByUsername(jwtRequest.getUsername());
		
		final String token=
				jwtUtility.generateToken(userDetails);
		
		return new JWTResponse(token);
	}
}
