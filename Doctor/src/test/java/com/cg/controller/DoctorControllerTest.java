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


import com.cg.model.Doctor;
import com.cg.service.DoctorService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
class DoctorControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private DoctorService ds;
	private Doctor d;
	private List<Doctor> doctorList;
	@InjectMocks
	private DoctorController doctor;
	
	@BeforeEach  
	public void setUp() {     //for set a value
		d=new Doctor(38,"ksu","Patna","heart");
		mockMvc = MockMvcBuilders.standaloneSetup(doctor).build();
		
	}
	
	//for add a value
	@Test
	public void addDoctorControllerTest() throws Exception{
		when(ds.addDoctor(any())).thenReturn(d);
		mockMvc.perform(post("/api/v1/addDoctor")
		  .contentType(MediaType.APPLICATION_JSON)
		  .content(asJSONString(d)))
		 .andExpect(status().isCreated());
		 verify(ds,times(1)).addDoctor(any());
	}
	
	//for retrive a value
	@Test
	public void getAllDoctorsControllerTest() throws Exception{
		when(ds.getAllDoctors()).thenReturn(doctorList);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/findAllDoctor")
				  .contentType(MediaType.APPLICATION_JSON)
				  .content(asJSONString(d)))
		          .andDo(MockMvcResultHandlers.print());
		          verify(ds,times(1)).getAllDoctors();
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
