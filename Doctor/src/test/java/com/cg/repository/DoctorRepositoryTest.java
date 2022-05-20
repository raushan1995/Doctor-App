package com.cg.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.model.Doctor;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class DoctorRepositoryTest {

	
	@Autowired
	private DoctorRepository repository;
	
	 @Test
	 public void givenDoctorShouldReturnDoctorObject() {
		 Doctor d1=new Doctor(1,"ram","Chennai","pain"); //user input
		 repository.save(d1); //saved into database
		 Doctor d2=repository.findById(d1.getDoctorid()).get(); //fetching data from database
		 assertNotNull(d2); //to check if it is returning the object
		 assertEquals(d1.getDoctorname(),d2.getDoctorname());
	 }

}
