package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Doctor;
import com.cg.model.JWTRequest;
import com.cg.model.JWTResponse;
import com.cg.repository.DoctorRepository;
import com.cg.service.UserService;
import com.cg.utility.JWTUtility;


	@RestController
	@RequestMapping("/api/v1")
	public class DoctorController {

//for jwt security
		
		@Autowired
		private JWTUtility jwtUtility;
		@Autowired

		private AuthenticationManager authenticationManager;
		
		@Autowired
		private UserService userService;
		
		//Get mapping
		@GetMapping("/")
		public String response() {
			return "Sucessfull Login";
		}
		
		//Post mapping
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

		// doctor class
	
		@Autowired
		private DoctorRepository repository;
		
		//post mapping 
		@PostMapping("/addDoctor")
		public String saveDoctor(@RequestBody Doctor doctor) {
			repository.save(doctor);
			return "add with id: "+ doctor.getDoctorid();
		}
		//get mapping 
		
		@GetMapping("/findAllDoctor")
		public List<Doctor> getDoctors(){
			return repository.findAll();
		}
		//put mapping url
		
		@PutMapping("/update")
		public int updateDoctor(@RequestBody Doctor doctor) {
		
			return doctor.getDoctorid();
		}

		

		
}
