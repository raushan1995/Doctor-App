package com.cg.repository;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.cg.model.Patient;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class PatientRepositoryTest {

	
	@Autowired
	private PatientRepository pentRepo;
	
	 @Test
	 public void givenPatientShouldReturnPatientObject() {
		 Patient p1=new Patient(10,"shyam","Chennai","pain"); //user input
		 pentRepo.save(p1); //saved into database
		 Patient p2=pentRepo.findById(p1.getId()).get(); //fetching data from database
		 assertNotNull(p2); //to check if it is returning the object
		 assertEquals(p1.getName(),p2.getName());
	 }
	 
	

}
