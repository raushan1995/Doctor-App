package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.model.Patient;
import com.cg.repository.PatientRepository;



@RestController
@RequestMapping("/api/v1")
public class PatientController {


	

	//from patient service
	
	@Autowired
	private PatientRepository repository;
	
	//post mapping
	@PostMapping("/addPatient")
	public String savePatient(@RequestBody Patient patient) {
		repository.save(patient);
		return "add with id: "+ patient.getId();
	}
	//get mapping
	
	@GetMapping("/findAllPatient")
	public List<Patient> getPatients(){
		return repository.findAll();
	}
	
}
