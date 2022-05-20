package com.cg.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.model.Doctor;

import com.cg.repository.DoctorRepository;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DoctorServiceTest {

	//repository
			@Mock
			private DoctorRepository repository;
			@InjectMocks
			private DoctorServiceImpl dsl;
			
			//add doctor
			@Test
			public void TestAddDoctor() throws FileAlreadyExistsException {
				Doctor d1= new Doctor(1,"ram","patna","pain"); //user input
				when(repository.save(any())).thenReturn(d1);
				dsl.addDoctor(d1); //data is saved in database
				verify(repository,times(1)).save(any());
			}
			 
			//get doctors 
			@Test
			public void testGetAllDoctors() {
				Doctor d1=new Doctor(10,"ram","Chennai","heart"); //user input
				Doctor d2=new Doctor(20,"Sales","Mumbai","pain"); //user input
				Doctor d3=new Doctor(30,"Admin","Delhi","heart"); //user input
				repository.save(d1);
				repository.save(d2);
				repository.save(d3); //saved in database
				
				List<Doctor>dList=new ArrayList<>(); //creating List Object
				dList.add(d1);
				dList.add(d2);
				dList.add(d3);
				
				when(repository.findAll()).thenReturn(dList);
				List<Doctor> dList1 = dsl.getAllDoctors();
				assertEquals(dList,dList1);
				verify(repository,times(1)).save(d1);
				verify(repository,times(1)).findAll();
				
			}
			
			//delete by id
			@Test
			public void TestDeleteBydoctorid() {
				repository.deleteById(10);
				}

}
