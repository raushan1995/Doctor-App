package com.cg.controller;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.model.Patient;

import com.cg.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
class PatientControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private PatientService ps;
	private Patient patient;
	private List<Patient> pList;

	
	@InjectMocks
	private PatientController pc;
	
	@BeforeEach
	public void setUp() {
		patient=new Patient(1,"ram","Patna","pain");
		mockMvc = MockMvcBuilders.standaloneSetup(pc).build();
		
	}
	
	@Test
	public void addPatientControllerTest() throws Exception{
		when(ps.addPatient(any())).thenReturn(patient);
		mockMvc.perform(post("/api/v1/addPatient")
		  .contentType(MediaType.APPLICATION_JSON)
		  .content(asJSONString(patient)))
		  .andExpect(status().isCreated());
		 verify(ps,times(1)).addPatient(any());
	}
	
	
	public static String asJSONString(final Object obj) {
		// TODO Auto-generated method stub
		try {
		return new ObjectMapper().writeValueAsString(obj);
	}catch(Exception e) {
		throw new RuntimeException(e);
	}
	
	}
}



